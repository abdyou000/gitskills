package com.huat.searchengine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huat.searchengine.dto.JsonResult;
import com.huat.searchengine.dto.UserDTO;
import com.huat.searchengine.entity.TblSearchHistory;
import com.huat.searchengine.entity.TblUser;
import com.huat.searchengine.service.SearchHistoryService;
import com.huat.searchengine.service.UserService;
import com.huat.searchengine.utils.FtpUtil;
import com.huat.searchengine.utils.IDUtil;
import com.huat.searchengine.utils.ImageUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private SearchHistoryService searchHistoryService;
	
	/**
	 * 去登录页面
	 * @return
	 */
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	/**
	 * 去注册页面
	 * @return
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/register")
	@ResponseBody
	public JsonResult register(UserDTO user,HttpSession session) throws Exception {
		//校验用户名，手机号是否已存在
		JsonResult result = userService.checkUsername(user.getUsername());
		if(result.getStatus() != 200) {
			return result;
		}
		result = userService.checkPhoneNumber(user.getPhoneNumber());
		if(result.getStatus() != 200) {
			return result;
		}
		String verifyNo = (String) session.getAttribute("verifyNo");
		if(user.getVerifyNo().equals(verifyNo)) {
			userService.insertUser(user);
			return JsonResult.ok();
		} 
		return JsonResult.build(402, "验证码错误");
	}
	
	/**
	 * 发送手机验证码
	 * @param phoneNumber
	 * @param session
	 * @return
	 */
	@RequestMapping("/sendsms")
	@ResponseBody
	public JsonResult sendSms(String phoneNumber,HttpSession session) {
		return userService.sendSms(phoneNumber,session);
	}
	
	
	@RequestMapping("/checkphone")
	@ResponseBody
	public JsonResult checkPhoneNumber(String phoneNumber) {
		JsonResult result = userService.checkPhoneNumber(phoneNumber);
		return result;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(UserDTO user,HttpSession session) {
		String verifyNo = (String) session.getAttribute("verifyNo");
		if(!verifyNo.equalsIgnoreCase(user.getVerifyNo())) {
			return JsonResult.build(400, "验证码错误");
		}
		JsonResult result = userService.login(user);
		if(result.getStatus() == 200) {
			session.setAttribute("user", result.getData());
		}
		return result;
	}
	/**
	 * 手机号验证码登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/plogin")
	@ResponseBody
	public JsonResult plogin(UserDTO user,HttpSession session) {
		String verifyNo = (String) session.getAttribute("verifyNo");
		if(user.getVerifyNo().equalsIgnoreCase(verifyNo)) {
			return userService.plogin(user,session);
		}
		return JsonResult.build(400, "验证码错误");
	}
	/**
	 * 获得图片验证码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getImage")
	@ResponseBody
	public String getImage(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        ImageUtil randomValidateCode = new ImageUtil();
        try {
            randomValidateCode.generateImage(request, response,"verifyNo");// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
	}
	
	/**
	 * 用户退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}
	
	/**
	 * 个人中心
	 * @return
	 */
	@RequestMapping("/toCenter")
	public String toCenter(String userId,Model model) {
		TblUser user = userService.getUserById(userId);
		System.out.println(user.getPhoneNumber());
		model.addAttribute("user", user);
		return "center";
	}
	
	/**
	 * 修改用户名
	 * @param oldName
	 * @param newName
	 * @return
	 */
	@RequestMapping("/changeUsername")
	@ResponseBody
	public JsonResult changeUsername(String userId,String newName,HttpSession session) {
		return userService.changeUsername(userId,newName,session);
	}
	
	@RequestMapping("/changePwd")
	@ResponseBody
	public JsonResult changePwd(String userId,String newPwd,HttpSession session) {
		return userService.changePwd(userId,newPwd,session);
	}
	
	@RequestMapping("/changePhone")
	@ResponseBody
	public JsonResult changePhone(UserDTO user,HttpSession session) throws Exception {
		return userService.changePhone(user,session);
	}
	@RequestMapping("/sendEmail")
	@ResponseBody
	public JsonResult sendEmail(String email,String username,HttpSession session) throws Exception {
		return userService.sendEmail(email,username,session);
	}
	@RequestMapping("/changeEmail")
	@ResponseBody
	public JsonResult changeEmail(UserDTO user,HttpSession session) throws Exception {
		return userService.changeEmail(user,session);
	}
	
	@RequestMapping(value="/upload")
	@ResponseBody
	public JsonResult upload(@RequestParam(value="fileupload",required=false) MultipartFile file,String userId,HttpSession session) throws Exception {
		System.out.println("文件上传");
		String uuid = IDUtil.generateUUID();
		String oldName = file.getOriginalFilename();
		String newName = uuid + oldName.substring(oldName.lastIndexOf("."));
		//将图片上传到图片服务器
		FtpUtil.uploadFile("localhost", 21, "ftpuser", "ftpuser", "/", "/", newName, file.getInputStream());
		String userAvatar = "http://localhost/"+newName;
		//修改用户的头像地址
		userService.changeAvatar(userId,userAvatar,session);
		//将头像地址返回，用来回显
		return JsonResult.ok(userAvatar);
	}
	
	/**
	 * 根据用户ID查询搜索记录
	 * @param expertId
	 * @return
	 */
	@RequestMapping(value="/searchHistory")
	@ResponseBody
	public JsonResult searchHistory(String userId,String content) {
		List<TblSearchHistory> historyList = searchHistoryService.getHistoryByExpertId(userId,content);
		return JsonResult.ok(historyList);
	}
}
