package com.example.demo.controller;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.LoginInfo;
import com.example.demo.service.InsertMyInfoService;
import com.example.demo.service.LoginService;
import com.example.demo.utills.AesUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SendEmailController {

    @Resource
    JavaMailSender mailSender;//自动注入
    @Resource
    LoginService loginService;
    @RequestMapping(value = "/static/article/sendEmail.do")
    @ResponseBody
    public Map sendEmail(String userName, String email, HttpServletRequest request) throws Exception {
        HashMap<String,String> map = new HashMap<>();
        userName = request.getParameter("userName");
        LoginInfo info = loginService.select(userName);
        String password = AesUtil.Aes128ToUnicode(info.getPassword());
        email = request.getParameter("qq");
        String content = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>找回密码</title>"
                + "<meta name=\"content-type\" content=\"text/html; charset=UTF-8\">"
                + "</head>"
                + "<body>"
                + "<p style=\"color:black\">用户"+userName+"的密码为:"+password+"</p>"
                + "</body>"
                + "</html>"; // 可以用HTMl语言写
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("1772657505@qq.com");//设置发信人，发信人需要和spring.mail.username配置的一样否则报错
            //name+="@qq.com";					//补全地址
            message.setTo(email);				//设置收信人
            message.setSubject("找回密码");	//设置主题
            message.setText(content,true);  	//第二个参数true表示使用HTML语言来编写邮件
            this.mailSender.send(mimeMessage);
            map.put("msg","已发送");
            return map;
        } catch (Exception ex) {
            ex.printStackTrace();
            map.put("msg","请检查信息是否完整");
            return map;
        }

    }
    @Resource
    InsertMyInfoService service;

    @RequestMapping(value = "/static/article/sendEmail2.do")
    @ResponseBody
    public Map sendEmail2(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = "src/main/resources/static/file/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        HashMap<String,String> map = new HashMap<>();
        FileOutputStream out = null;
        out = new FileOutputStream(filePath+fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();
        //HashMap<String, String> map = new HashMap<>();
        String recipient = request.getParameter("recipient");
        String title = request.getParameter("title");
        String text1 = request.getParameter("text");
        String content = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>"+title+"</title>"
                + "<meta name=\"content-type\" content=\"text/html; charset=UTF-8\">"
                + "</head>"
                + "<body>"
                + "<p style=\"color:black\">" +text1+ "</p>"
                + "</body>"
                + "</html>"; // 可以用HTMl语言写
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
            message.setFrom("1772657505@qq.com");//设置发信人，发信人需要和spring.mail.username配置的一样否则报错
            //name+="@qq.com";					//补全地址
            message.setTo(recipient+"@qq.com");                //设置收信人
            message.setSubject(title);    //设置主题
            message.setText(content, true);    //第二个参数true表示使用HTML语言来编写邮件
            FileSystemResource file1 = new FileSystemResource(new File("src//main//resources//static//file//"+fileName));
            message.addAttachment(fileName, file1);//添加带附件的邮件  
            //message.addInline(fileName,file1);//添加带静态资源的邮件
            this.mailSender.send(mimeMessage);
            EmailInfo info = new EmailInfo();
            info.setRecipient(recipient);
            info.setFilePath(filePath+fileName);
            info.setSender("1772657505@qq.com");
            info.setText1(text1);
            info.setTitle(title);
            int n = service.insertEmail(info);
            if(n>0){
                map.put("msg", "已发送");
                return map;
            }
            else{
                map.put("msg","发送失败");
                return map;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            map.put("msg", "发送失败");
            return map;
        }
    }
}
