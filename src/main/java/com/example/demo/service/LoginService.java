package com.example.demo.service;

import com.example.demo.entity.LoginInfo;
import java.util.List;


public interface LoginService {
    List<LoginInfo> login(LoginInfo info);

    List<LoginInfo> adminLogin(LoginInfo info);

    LoginInfo select(String userName);
}
