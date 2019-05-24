package com.example.demo.controller;

import com.example.demo.entity.FileInfo;
import com.example.demo.entity.SelectInfo;
import com.example.demo.service.InsertMyInfoService;
import com.example.demo.utills.AesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeadImgController {
    @Resource InsertMyInfoService infoService;
    @RequestMapping("/static/article/upload.do")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //String userName = request.getParameter("userName");
        //System.out.println(userName);
        SelectInfo selectInfo = new SelectInfo();
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = "src/main/resources/static/images/HeadImgs/";
        selectInfo.setUserName(request.getParameter("userName"));
        selectInfo.setPassword(AesUtil.unicodeToAes128(request.getParameter("password")));
        selectInfo.setPhone(request.getParameter("phone"));
        selectInfo.setQq(request.getParameter("qq"));
        selectInfo.setPath(filePath+fileName);
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        HashMap<String,String> map = new HashMap<>();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            System.out.println(filePath+fileName);
            System.out.println();
            out.write(file.getBytes());
            out.flush();
            out.close();
            //System.out.println("over");
        } catch (Exception e) {
            map.put("msg","修改信息失败");
            return map;
        }
        int first =  infoService.insertMyInfo(selectInfo);
        if(first==0){
            int second = infoService.insertMyInfo1(selectInfo);
            if(second==0){
                map.put("msg","修改信息失败");
            }
            if(second>0){
                map.put("msg","修改信息成功");
            }
        }
        map.put("msg","修改信息成功");
        return map;
    }
    @RequestMapping("/static/article/uploadHeTong.do")
    @ResponseBody
    public Map uploadHeTong(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        FileInfo fileInfo = new FileInfo();
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = "src/main/resources/static/file/";
        fileInfo.setCname(request.getParameter("cname"));
        fileInfo.setHname(request.getParameter("hname"));
        fileInfo.setBeizhu(request.getParameter("beizhu"));
        fileInfo.setGuishu(request.getParameter("guishu"));
        fileInfo.setPath1(filePath+fileName);
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        HashMap<String,String> map = new HashMap<>();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            System.out.println(filePath+fileName);
            //System.out.println();
            out.write(file.getBytes());
            out.flush();
            out.close();
            //System.out.println("over");
        } catch (Exception e) {
            map.put("msg","fail");
            return map;
        }
        int first =  infoService.uploadFile(fileInfo);
        if(first==0){
            map.put("msg","fail");
        }
        map.put("msg","success");
        return map;
    }
}
