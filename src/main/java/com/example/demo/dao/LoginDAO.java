package com.example.demo.dao;

import com.example.demo.entity.LoginInfo;
import java.util.List;

public interface LoginDAO {
    List<LoginInfo> login(LoginInfo info);

    List<LoginInfo> adminLogin(LoginInfo info);

    LoginInfo select(String userName);
}
