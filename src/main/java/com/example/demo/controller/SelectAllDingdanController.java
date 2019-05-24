package com.example.demo.controller;

import com.example.demo.entity.DingdanInfo;
import com.example.demo.entity.TypeInfo;
import com.example.demo.service.SelectInfoService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectAllDingdanController {
    @Resource
    SelectInfoService service;

    @ResponseBody
    @RequestMapping("/static/article/selectAllDingdan.do")
    public Map selectAllDingdan(){
        List<DingdanInfo> list = service.selectAllDingdan();
        LinkedHashMap<String,DingdanInfo> hashMap = new LinkedHashMap<>();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectGoodsType.do")
    public Map selectGoodsType(){
        List<TypeInfo> list = service.selectGoodsType();
        LinkedHashMap<String,TypeInfo> hashMap = new LinkedHashMap<>();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectCname.do")
    public Map selectCname(){
        List<TypeInfo> list = service.selectCname();
        LinkedHashMap<String,TypeInfo> hashMap = new LinkedHashMap<>();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectMyDingdan.do")
    public Map selectMyDingdan(HttpServletRequest request){
        DingdanInfo info = new DingdanInfo();
        info.setCreatePerson(request.getParameter("userName"));
        List<DingdanInfo> list = service.selectMyDingdan(info);
        LinkedHashMap<String,DingdanInfo> hashMap = new LinkedHashMap<>();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectState0Dingdan.do")
    public Map selectState0Dingdan(HttpServletRequest request){
        List<DingdanInfo> list = service.selectState0Dingdan();
        LinkedHashMap<String,DingdanInfo> hashMap = new LinkedHashMap<>();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                hashMap.put("user"+i,list.get(i));
            }
            return hashMap;
        }
        return null;
    }
}
