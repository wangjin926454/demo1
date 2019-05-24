package com.example.demo.controller;

import com.example.demo.service.LoginService;
import com.example.demo.entity.LoginInfo;
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
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Map login(HttpServletRequest request){
        LoginInfo info = new LoginInfo();
        Map<String,String> map = new HashMap<>();
        info.setUserName(request.getParameter("userName"));
        info.setPassword(AesUtil.unicodeToAes128(request.getParameter("password")));
        info.setType(request.getParameter("type"));
        System.out.println(info.getType());
        if("1".equals(info.getType())){
            List<LoginInfo> list = loginService.adminLogin(info);
            if(!list.isEmpty()){
                map.put("loginSuccess","success");
                map.put("userName",list.get(0).getUserName());
                map.put("type","1");
            }else {
                map.put("loginSuccess","error");
            }
        }
        else {
            List<LoginInfo> list = loginService.login(info);
            if(!list.isEmpty()){
                map.put("loginSuccess","success");
                map.put("userName",list.get(0).getUserName());
                map.put("type","0");
            }else {
                map.put("loginSuccess","error");
            }
        }
        System.out.println(map);
        return map;
    }
}
