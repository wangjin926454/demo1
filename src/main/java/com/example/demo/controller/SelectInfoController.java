package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.SelectInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SelectInfoController {
    @Resource
    SelectInfoService indexService;

    @RequestMapping("/static/article/selectInfo.do")
    @ResponseBody
    public Map selectInfo(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("utf-8");
        SelectInfo selectInfo = new SelectInfo();
        selectInfo.setUserName(request.getParameter("userName"));
        System.out.println(request.getParameter("userName"));
        HashMap<String,String> map = new HashMap<>();
        SelectInfo selectInfo1 = indexService.selectInfo(selectInfo);
        if(selectInfo1!=null){
            map.put("name",selectInfo1.getName());
            map.put("zhiwu",selectInfo1.getZhiwu());
            map.put("bumen",selectInfo1.getBumen());
            map.put("path",selectInfo1.getPath());
            return map;
        }else{
            selectInfo = indexService.selectInfo1(selectInfo);
            map.put("name",selectInfo.getName());
            map.put("zhiwu",selectInfo.getZhiwu());
            map.put("bumen",selectInfo.getBumen());
            map.put("path",selectInfo.getPath());
            return map;
        }
    }
    @RequestMapping("/static/article/selectInfo1.do")
    @ResponseBody
    public Map selectInfo1(HttpServletRequest request){
        SelectInfo selectInfo = new SelectInfo();
        selectInfo.setUserName(request.getParameter("userName"));
        HashMap<String,String> map = new HashMap<>();
        SelectInfo selectInfo1 = indexService.selectInfo(selectInfo);
        //System.out.println(selectInfo1.getPath());
        if(selectInfo1!=null){
            map.put("userName",selectInfo1.getUserName());
            map.put("name",selectInfo1.getName());
            map.put("phone",selectInfo1.getPhone());
            map.put("qq",selectInfo1.getQq());
            map.put("zhiwu",selectInfo1.getZhiwu());
            map.put("bumen",selectInfo1.getBumen());
            map.put("type",selectInfo1.getType());
            map.put("state",selectInfo1.getState());
            map.put("ctype",selectInfo1.getCtype());
            map.put("path",selectInfo1.getPath());
            return map;
        }else{
            selectInfo = indexService.selectInfo1(selectInfo);
            map.put("userName",selectInfo.getUserName());
            map.put("name",selectInfo.getName());
            map.put("phone",selectInfo.getPhone());
            map.put("qq",selectInfo.getQq());
            map.put("zhiwu",selectInfo.getZhiwu());
            map.put("bumen",selectInfo.getBumen());
            map.put("type",selectInfo.getType());
            map.put("state",selectInfo.getState());
            map.put("ctype",selectInfo.getCtype());
            map.put("path",selectInfo.getPath());
            //System.out.println(selectInfo.getPath());
            return map;
        }
    }
    @RequestMapping("/static/article/selectFile.do")
    @ResponseBody
    public Map selectFile(HttpServletRequest request){
        //SelectInfo selectInfo = new SelectInfo();
        FileInfo fileInfo = new FileInfo();
        //selectInfo.setUserName(request.getParameter("userName"));
        HashMap<String,Object> map = new HashMap<>();
        List<FileInfo> selectInfo1 = indexService.selectFile();
        if(selectInfo1.isEmpty()){
            map.put("msg","fail");
            return map;
        }
        for(int i=0;i<selectInfo1.size();i++){
            map.put("user"+i,selectInfo1.get(i));
        }
        return map;
    }
    @RequestMapping("/static/article/selectMessage.do")
    @ResponseBody
    public Map selectMessage(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        List<MessageInfo> list = indexService.selectMessage();
        if(list.isEmpty()){
            map.put("msg","fail");
            return map;
        }
        for(int i=0;i<list.size();i++){
            map.put("user"+i,list.get(i));
        }
        return map;
    }
    @RequestMapping("/static/article/selectEmailByID.do")
    @ResponseBody
    public EmailInfo selectEmailByID(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        EmailInfo info = new EmailInfo();
        info.setId(request.getParameter("id"));
        EmailInfo info1 = indexService.selectEmailByID(info);
        if(info1!=null){
            return info1;
        }
        return info1;
    }
    @RequestMapping("/static/article/selectDingdanInfoByID.do")
    @ResponseBody
    public DingdanInfo selectDingdanInfoByID(HttpServletRequest request){
        DingdanInfo info = new DingdanInfo();
        info.setId(request.getParameter("id"));
        DingdanInfo info1 = indexService.selectDingdanInfoByID(info);
        if(info1!=null){
            return info1;
        }
        return info1;
    }
}
