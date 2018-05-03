package com.huat.searchengine.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.dto.UserDTO;
import com.huat.searchengine.entity.TblUser;
import com.huat.searchengine.entity.TblUserExample;
import com.huat.searchengine.entity.TblUserExample.Criteria;
import com.huat.searchengine.enums.UrlEnum;
import com.huat.searchengine.mapper.TblUserMapper;
import com.huat.searchengine.utils.IDUtil;

import freemarker.template.Template;


@Service
public class UserService {

	// 短信API产品名称（短信产品名固定，无需修改）
//	@Value("${sms.product}")
//	private String product;
//	// 短信API产品域名（接口地址固定，无需修改）
//	@Value("${sms.domain}")
//	private String domain;
//	// 你的accessKeyId,参考本文档步骤2
//	@Value("${sms.accessKeyId}")
//	private String accessKeyId;
//	// 你的accessKeySecret，参考本文档步骤2
//	@Value("${sms.accessKeySecret}")
//	private String accessKeySecret;
//	// 必填:短信签名-可在短信控制台中找到
//	@Value("${sms.signName}")
//	private String signName;
//	// 必填:短信模板-可在短信控制台中找到
//	@Value("${sms.templateCode}")
//	private String templateCode;

	public JsonResult sendSms(String phoneNumber, HttpSession session) {
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		//初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        final String accessKeyId = "LTAIh1rJoLKBoei0";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "oNcEosFbCzUXr79GZ6ouskdAoJy9lP";//你的accessKeySecret，参考本文档步骤2

		// 初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。
		request.setPhoneNumbers(phoneNumber);
		//必填:短信签名-可在短信控制台中找到
        request.setSignName("史振忠");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_131030133");
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		String verifyNo = IDUtil.generateVerifyNo();
		request.setTemplateParam("{\"code\":"+verifyNo+"}");
		// 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("code:"+sendSmsResponse.getCode());
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			// 请求成功
			System.out.println("短信发送成功");
			session.setAttribute("verifyNo", verifyNo);
			return JsonResult.ok();
		}
		return JsonResult.build(404, "短信发送出错");
	}
	
	@Autowired
	private TblUserMapper userMapper;
	
	public void insertUser(UserDTO user) throws Exception {
		String userId = IDUtil.generateUUID();
		user.setUserId(userId);
		user.setCreateTime(new Date().getTime());
		user.setLastUpdateTime(new Date().getTime());
		user.setUserAvatar(UrlEnum.USER_DEFAULT_AVATAR.toString());
		//MD5加密
		String newPwd = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
		user.setPwd(newPwd);
		TblUser tblUser = new TblUser();
		BeanUtils.copyProperties(tblUser, user);
		userMapper.insertSelective(tblUser);
	}
	
	public JsonResult checkUsername(String username) {
		TblUserExample example = new TblUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TblUser> users = userMapper.selectByExample(example );
		if(users != null && !users.isEmpty()) {
			return JsonResult.build(400, "用户名重复");
		}
		return JsonResult.ok();
	}
	
	public JsonResult checkPhoneNumber(String phoneNumber) {
		TblUserExample example = new TblUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumberEqualTo(phoneNumber);
		List<TblUser> users = userMapper.selectByExample(example);
		if(users != null && !users.isEmpty()) {
			return JsonResult.build(401, "手机号重复");
		}
		return JsonResult.ok();
	}

	public JsonResult login(UserDTO user) {
		TblUserExample example = new TblUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPwdEqualTo(user.getPwd());
		List<TblUser> users = userMapper.selectByExample(example );
		if(users != null && !users.isEmpty()) {
			//修改用户的上次登录时间
			TblUser record = new TblUser();
			record.setLastLoginTime(new Date().getTime());
			userMapper.updateByExampleSelective(record, example);
			return JsonResult.ok(users.get(0));
		}
		return JsonResult.build(401, "用户名或密码错误");
	}

	/**
	 * 手机验证码登录
	 * @param user
	 * @param session
	 * @return
	 */
	public JsonResult plogin(UserDTO user, HttpSession session) {
		String phoneNumber = user.getPhoneNumber();
		TblUserExample example = new TblUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumberEqualTo(phoneNumber);
		List<TblUser> users = userMapper.selectByExample(example );
		//如果手机号已存在，表示已经注册过
		if(users != null && !users.isEmpty()) {
			session.setAttribute("user", users.get(0));
			//更新上次登录时间
			TblUser tblUser = new TblUser();
			tblUser.setLastLoginTime(new Date().getTime());
			userMapper.updateByExampleSelective(tblUser, example);
		} else {
			//表示还没有注册过
			TblUser tblUser = new TblUser();
			tblUser.setUserId(IDUtil.generateUUID());
			String username = phoneNumber.substring(0, 3) + "****"  + phoneNumber.substring(7,phoneNumber.length());
			tblUser.setUsername(username);
			long now = System.currentTimeMillis();
			tblUser.setPhoneNumber(phoneNumber);
			tblUser.setCreateTime(now);
			tblUser.setLastUpdateTime(now);
			tblUser.setLastLoginTime(now);
			tblUser.setUserAvatar(UrlEnum.USER_DEFAULT_AVATAR.toString());
			userMapper.insertSelective(tblUser);
			session.setAttribute("user", tblUser);
		}
		return JsonResult.ok();
	}
	
	/**
	 * 去个人中心
	 * @return
	 */
	public String toCenter() {
		return "center";
	}

	/**
	 * 修改用户名
	 * @param oldName
	 * @param newName
	 * @param session 
	 * @return
	 */
	public JsonResult changeUsername(String userId,String newName, HttpSession session) {
		TblUser user = new TblUser();
		user.setUsername(newName);
		user.setUserId(userId);
		userMapper.updateByPrimaryKeySelective(user);
		this.updateSession(session, userId);
		return JsonResult.ok();
	}

	public void updateSession(HttpSession session,String userId) {
		TblUser user = userMapper.selectByPrimaryKey(userId);
		session.setAttribute("user", user);
	}
	public TblUser getUserById(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public JsonResult changePwd(String userId, String pwd, HttpSession session) {
		TblUser user = new TblUser();
		//MD5加密
		String newPwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
		user.setPwd(newPwd);
		user.setUserId(userId);
		userMapper.updateByPrimaryKeySelective(user);
		this.updateSession(session, userId);
		return JsonResult.ok();
	}

	public JsonResult changePhone(UserDTO user, HttpSession session) throws Exception {
		String verifyNo = (String) session.getAttribute("verifyNo");
		if(verifyNo.equalsIgnoreCase(user.getVerifyNo())) {
			//修改绑定手机
			TblUser tblUser = new TblUser();
			BeanUtils.copyProperties(tblUser, user);
			userMapper.updateByPrimaryKeySelective(user);
			this.updateSession(session, user.getUserId());
			return JsonResult.ok();
		}
		return JsonResult.build(400, "验证码错误");
	}

	
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	public JsonResult sendEmail(String email, String username, HttpSession session) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String from = "18925517692@163.com";
        String to = email;
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("邮箱绑定");
        String verifyNo = IDUtil.generateVerifyNo();
        session.setAttribute("verifyNo", verifyNo);
        helper.setText(getText(email,username,verifyNo), true);//第二个参数表明这是一个HTML
        mailSender.send(message);
        return JsonResult.ok();
	}
	
	private String getText(String email, String username, String verifyNo) throws Exception{
    	// 通过指定模板名获取FreeMarker模板实例  
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");   
        // FreeMarker通过Map传递动态数据  
        Map<String, String> map = new HashMap<String, String>();   
        map.put("username", username); // 注意动态数据的key和模板标签中指定的属性相匹配  
        map.put("verifyNo", verifyNo);  
        map.put("email", email);   
        // 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。  
        String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);  
        return htmlText;  
    }

	public JsonResult changeEmail(UserDTO user, HttpSession session) throws Exception {
		String verifyNo = (String) session.getAttribute("verifyNo");
		if(verifyNo.equalsIgnoreCase(user.getVerifyNo())) {
			//修改绑定邮箱
			TblUser tblUser = new TblUser();
			BeanUtils.copyProperties(tblUser, user);
			userMapper.updateByPrimaryKeySelective(user);
			this.updateSession(session, user.getUserId());
			return JsonResult.ok();
		}
		return JsonResult.build(400, "验证码错误");
	}

	public void changeAvatar(String userId, String userAvatar, HttpSession session) {
		TblUser user = new TblUser();
		user.setUserId(userId);
		user.setUserAvatar(userAvatar);
		userMapper.updateByPrimaryKeySelective(user);
		this.updateSession(session, userId);
	}
}
