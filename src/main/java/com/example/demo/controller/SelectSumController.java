package com.example.demo.controller;

import com.example.demo.entity.Tongji;
import com.example.demo.service.SelectInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectSumController {
    @Resource
    SelectInfoService service;

    @ResponseBody
    @RequestMapping("/static/article/selectSumMoney.do")
    public Map selectSumMoney(){
        HashMap<String, Tongji> map = new HashMap<>();
        List<Tongji> list = service.selectSumMoney();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                map.put(list.get(i).getMonth1(),list.get(i));
            }
            return map;
        }
        return null;
    }
    @ResponseBody
    @RequestMapping("/static/article/selectYearSumMoney.do")
    public Map selectYearSumMoney(){
        HashMap<String, Tongji> map = new HashMap<>();
        List<Tongji> list = service.selectYearSumMoney();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                map.put(list.get(i).getYear1(),list.get(i));
            }
            return map;
        }
        return null;
    }
}
