package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.SaveAllUserService;
import com.example.demo.utills.AesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller

public class SaveAllUserInfoController {
    @Resource
    SaveAllUserService service;

    @RequestMapping("/static/article/saveAllUserInfo.do")
    @ResponseBody
    public Map saveAllUserInfo(HttpServletRequest request){
        SelectMyUsersInfo usersInfo = new SelectMyUsersInfo();
        usersInfo.setCid(request.getParameter("cid"));
        usersInfo.setCguishu(request.getParameter("cguishu"));
        usersInfo.setCaddress(request.getParameter("caddress"));
        usersInfo.setCboss(request.getParameter("cboss"));
        usersInfo.setCname(request.getParameter("cname"));
        usersInfo.setCover(request.getParameter("cover"));
        usersInfo.setCqq(request.getParameter("cqq"));
        usersInfo.setCwww(request.getParameter("cwww"));
        usersInfo.setCphone(request.getParameter("cphone"));
        usersInfo.setCtype(request.getParameter("ctype"));
        usersInfo.setYixiang(request.getParameter("yixiang"));
        usersInfo.setCtellp(request.getParameter("ctellp"));
        int n = service.savaAllUser(usersInfo);
        HashMap<String,String> map = new HashMap<>();
        if(n>0){
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;

    }
    @RequestMapping("/static/article/saveUser11.do")
    @ResponseBody
    public Map saveUser11(HttpServletRequest request){
        UserInfo usersInfo = new UserInfo();
        usersInfo.setUserName(request.getParameter("cid"));
        //usersInfo.setCguishu(request.getParameter("cguishu"));
        //usersInfo.setCaddress(request.getParameter("caddress"));
        usersInfo.setUserName(request.getParameter("userName"));
        usersInfo.setName(request.getParameter("name"));
        usersInfo.setPhone(request.getParameter("phone"));
        usersInfo.setQq(request.getParameter("qq"));
        usersInfo.setZhiwu(request.getParameter("zhiwu"));
        usersInfo.setBumen(request.getParameter("bumen"));
        usersInfo.setCtype(request.getParameter("ctype"));
        usersInfo.setType(request.getParameter("type"));
        usersInfo.setState(request.getParameter("state"));
        int n = service.saveUser11(usersInfo);
        HashMap<String,String> map = new HashMap<>();
        if(n>0){
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;

    }
    @RequestMapping("/static/article/saveSave1.do")
    @ResponseBody
    public Map saveSave1(HttpServletRequest request){
        UserInfo usersInfo = new UserInfo();
        usersInfo.setPassword(AesUtil.unicodeToAes128(request.getParameter("userName")));
        usersInfo.setUserName(request.getParameter("userName"));
        usersInfo.setName(request.getParameter("name"));
        usersInfo.setPhone(request.getParameter("phone"));
        usersInfo.setQq(request.getParameter("qq"));
        usersInfo.setType(request.getParameter("type"));
        usersInfo.setCtype(request.getParameter("ctype"));
        usersInfo.setZhiwu(request.getParameter("zhiwu"));
        usersInfo.setBumen(request.getParameter("bumen"));
        int n = service.saveSave1(usersInfo);
        HashMap<String,String> map = new HashMap<>();
        if(n>0){
            map.put("msg","保存成功");
            return map;
        }
        map.put("msg","保存失败");
        return map;

    }

    @RequestMapping("/static/article/delete.do")
    @ResponseBody
    public Map deleteUser(HttpServletRequest request){
        SelectMyUsersInfo usersInfo = new SelectMyUsersInfo();
        usersInfo.setCid(request.getParameter("cid"));
        HashMap<String,String> map = new HashMap<>();
        int n = service.deleteUser(usersInfo);
        if(n>0){
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;
    }
    @RequestMapping("/static/article/deleteUser1.do")
    @ResponseBody
    public Map deleteUser1(HttpServletRequest request){
        UserInfo usersInfo = new UserInfo();
        usersInfo.setUserName(request.getParameter("user"));
        HashMap<String,String> map = new HashMap<>();
        int n = service.deleteUser1(usersInfo);
        if(n>0){
            map.put("msg","删除成功");
            return map;
        }
        map.put("msg","删除失败");
        return map;
    }
    @RequestMapping("/static/article/createUser.do")
    @ResponseBody
    public Map createUser(HttpServletRequest request){
        SelectMyUsersInfo usersInfo = new SelectMyUsersInfo();
        //usersInfo.setCid(request.getParameter("cid"));
        //usersInfo.setCguishu(request.getParameter("cguishu"));
        usersInfo.setCaddress(request.getParameter("caddress"));
        usersInfo.setCboss(request.getParameter("cboss"));
        usersInfo.setCname(request.getParameter("cname"));
        usersInfo.setCover(request.getParameter("cover"));
        usersInfo.setCqq(request.getParameter("cqq"));
        usersInfo.setCwww(request.getParameter("cwww"));
        usersInfo.setCphone(request.getParameter("cphone"));
        usersInfo.setCtype(request.getParameter("ctype"));
        usersInfo.setCguishu(request.getParameter("cguishu"));
        int yixiang = Integer.parseInt(request.getParameter("yixiang"));
        switch (yixiang){
            case 1:{
                usersInfo.setYixiang("意向强烈");
                break;
            }
            case 2:{
                usersInfo.setYixiang("意向一般");
                break;
            }
            case 3:{
                usersInfo.setYixiang("已成交");
                break;
            }
            case 4:{
                usersInfo.setYixiang("意向无");
                break;
            }
        }
        usersInfo.setCtellp(request.getParameter("ctellp"));
       // System.out.println(usersInfo.toString());
        HashMap<String,String> map = new HashMap<>();
        int n = service.createUser(usersInfo);
        if(n>0){
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;

    }
    @RequestMapping("/static/article/saveMessage.do")
    @ResponseBody
    public Map saveMessage(HttpServletRequest request){
        HashMap<String,String> map = new HashMap<>();
        MessageInfo messageInfo = new MessageInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messageInfo.setCreatetime(sdf.format(new Date()));
        messageInfo.setMessage(request.getParameter("message"));
        messageInfo.setMtitle(request.getParameter("mtitle"));
        messageInfo.setUserName(request.getParameter("userName"));
        int n = service.saveMessage(messageInfo);
        if(n>0){
            map.put("msg","success");
            return map;
        }
        map.put("msg","fail");
        return map;

    }
    @RequestMapping("/static/article/saveDingdanByID.do")
    @ResponseBody
    public Map saveDingdanByID(HttpServletRequest request){
        HashMap<String,String> hashMap = new HashMap<>();
        DingdanInfo info = new DingdanInfo();
        info.setId(request.getParameter("id"));
        info.setBeizhu(request.getParameter("beizhu"));
        info.setMoney(request.getParameter("money"));
        info.setState(request.getParameter("state"));
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = sdf.format(new Date());
        info.setUpdateTime(datetime);
        //System.out.println(info.getId());
        int n = service.updateDingdanByID(info);
        if(n>0){
            hashMap.put("msg","更新成功");
            return hashMap;
        }
        hashMap.put("msg","更新失败");
        return hashMap;
    }
    @RequestMapping("/static/article/deleteDingdanByID.do")
    @ResponseBody
    public Map deleteDingdanByID(HttpServletRequest request){
        HashMap<String,String> hashMap = new HashMap<>();
        DingdanInfo info = new DingdanInfo();
        info.setId(request.getParameter("id"));
        System.out.println(info.getId());
        int n = service.delectDingdanByID(info);
        if(n>0){
            hashMap.put("msg","删除成功");
            return hashMap;
        }
        hashMap.put("msg","删除失败");
        return hashMap;
    }
    @RequestMapping("/static/article/saveNewGoodType.do")
    @ResponseBody
    public Map saveNewGoodType(HttpServletRequest request){
        HashMap<String,String> hashMap = new HashMap<>();
        TypeInfo info = new TypeInfo();
        info.setGoodType(request.getParameter("goodType"));
       // System.out.println(info.getId());
        int n = service.saveNewGoodType(info);
        if(n>0){
            hashMap.put("msg","添加成功");
            return hashMap;
        }
        hashMap.put("msg","添加失败");
        return hashMap;
    }
    @RequestMapping("/static/article/saveNewDingdan.do")
    @ResponseBody
    public Map saveNewDingdan(HttpServletRequest request){
        HashMap<String,String> hashMap = new HashMap<>();
        DingdanInfo info = new DingdanInfo();
        info.setGoodType(request.getParameter("goodType"));
        info.setCreatePerson(request.getParameter("createPerson"));
        info.setCname(request.getParameter("cname"));
        info.setMoney(request.getParameter("money"));
        info.setBeizhu(request.getParameter("beizhu"));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sf.format(new Date());
        info.setCreateTime(date);
        info.setUpdateTime(date);
        int n = service.saveNewDingdan(info);
        if(n>0){
            hashMap.put("msg","添加成功");
            return hashMap;
        }
        hashMap.put("msg","添加失败");
        return hashMap;
    }
}
