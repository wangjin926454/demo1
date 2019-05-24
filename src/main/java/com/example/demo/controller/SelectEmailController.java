package com.example.demo.controller;

import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.SelectMyUsersInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.SelectMyUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class SelectEmailController {
    @Resource
    SelectMyUsersService service;

    @ResponseBody
    @RequestMapping("/static/article/selectEmail.do")
    public Map selectEmail(){
        List<SelectMyUsersInfo> list= service.selectAllUsers();
        if(!list.isEmpty()){
            HashMap<String,SelectMyUsersInfo> hashMap = new HashMap<>();
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectEmail1.do")
    public Map selectEmail1(){
        List<UserInfo> list= service.selectUsers();
        if(!list.isEmpty()){
            HashMap<String,UserInfo> hashMap = new HashMap<>();
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectEmail2.do")
    public Map selectEmail2(){
        List<EmailInfo> list= service.selectSended();
        if(!list.isEmpty()){
            HashMap<String,EmailInfo> hashMap = new HashMap<>();
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
}
