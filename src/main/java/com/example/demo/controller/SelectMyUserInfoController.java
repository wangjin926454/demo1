package com.example.demo.controller;

import com.example.demo.entity.SelectMyUsersInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.SelectMyUsersService;
import com.example.demo.utills.AesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectMyUserInfoController {
    @Resource
    SelectMyUsersService selectMyUsersService;

    @RequestMapping("/static/article/selectMyUsersInfo.do")
    @ResponseBody
    public Map selectMyUsers(HttpServletRequest request){
        HashMap<String,SelectMyUsersInfo> map = new HashMap<>();
        SelectMyUsersInfo myUsersInfo = new SelectMyUsersInfo();
        myUsersInfo.setCguishu(request.getParameter("userName"));
        List<SelectMyUsersInfo> list = selectMyUsersService.selectMyUsers(myUsersInfo);
        //int n = selectMyUsersService.selectMyUsers1();
        //map.put("countTotal",n);
        for(int i=0;i<list.size();i++){
            map.put("user"+i,list.get(i));
        }
        return map;
    }
    @RequestMapping("/static/article/selectAllUsersInfo1.do")
    @ResponseBody
    public Map selectAllUsers(HttpServletRequest request){
        HashMap<String,SelectMyUsersInfo> map = new HashMap<>();
        List<SelectMyUsersInfo> list = selectMyUsersService.selectAllUsers();
        for(int i=0;i<list.size();i++){
            map.put("user"+i,list.get(i));
        }
        return map;
    }
    @RequestMapping("/static/article/selectAllUsersInfo.do")
    @ResponseBody
    public Map selectMyAllUsers(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        //SelectMyUsersInfo myUsersInfo = new SelectMyUsersInfo();
        //myUsersInfo.setCguishu(request.getParameter("userName"));
        //List<SelectMyUsersInfo> list = selectMyUsersService.selectMyUsers(myUsersInfo);
        int n = selectMyUsersService.selectMyUsers1();
        map.put("countTotal",n);
        return map;
    }
    @RequestMapping("/static/article/searchUser.do")
    @ResponseBody
    public Map searchUser(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        SelectMyUsersInfo usersInfo = new SelectMyUsersInfo();
        int over = Integer.parseInt(request.getParameter("cover"));
        switch (over){
            case  1:{
                usersInfo.setCover("已成交");
                break;
            }
            case  2:{
                usersInfo.setCover("未成交");
                break;
            }
        }
        int yixiang = Integer.parseInt(request.getParameter("yixiang"));
        System.out.println(yixiang);
        switch (yixiang){
            case  1:{
                usersInfo.setYixiang("意向强烈");
                break;
            }
            case  2:{
                usersInfo.setYixiang("意向一般");
                break;
            }
            case  3:{
                usersInfo.setYixiang("已合作");
                break;
            }
            case  4:{
                usersInfo.setYixiang("意向无");
                break;
            }
        }
        usersInfo.setCqq(request.getParameter("info"));
        List<SelectMyUsersInfo> list = selectMyUsersService.search(usersInfo);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            map.put("user"+i,list.get(i));
        }
        return map;
    }
    @RequestMapping("/static/article/searchAll.do")
    @ResponseBody
    public Map searchAll(HttpServletRequest request) throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        UserInfo usersInfo = new UserInfo();
        usersInfo.setUserName(request.getParameter("userName"));
        List<UserInfo> list = selectMyUsersService.selectAll(usersInfo);
        //System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            //list.get(i).setUserName(AesUtil.Aes128ToUnicode(list.get(i).getUserName()));
            map.put("user"+i,list.get(i));
            //return map;
        }
        //map.put("msg","没有数据");
        return map;
    }
}
