package com.huat.searchengine.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/** 
 * @date 2018年4月27日 
 * 
 * @author 史振忠 
 * 
 * @Description: TODO  
 * 
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-service.xml"}) //加载配置文件 
public class TestSendEmail {

	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("18925517692@163.com");//发件人
        message.setTo("15872680284@163.com");//收件人
        message.setSubject("aaa");//主题
        message.setText("hello world!!");//正文
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }
    
    @Test
    public void sendRichEmail() throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("18925517692@163.com");
        helper.setTo("15872680284@163.com");
        helper.setSubject("邮箱绑定");
        helper.setText(getText(), true);//第二个参数表明这是一个HTML
        //src='cid:testLogo'表明在消息中会有一部分是图片并以testLogo来进行标识
//        ClassPathResource image = new ClassPathResource("logo.jpg");
//        System.out.println(image.exists());
//        helper.addInline("testLogo", image);//添加内联图片，第一个参数表明内联图片的标识符，第二个参数是图片的资源引用
        mailSender.send(message);
    }	
    
    private String getText() throws Exception{
    	// 通过指定模板名获取FreeMarker模板实例  
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("email.ftl");   
          
        // FreeMarker通过Map传递动态数据  
        Map<String, String> map = new HashMap<String, String>();   
        map.put("username", "username2"); // 注意动态数据的key和模板标签中指定的属性相匹配  
        map.put("verifyNo", "1234");  
        map.put("email", "18925517692@163.com");
          
        // 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。  
        String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);  
        return htmlText;  
    }
}
  