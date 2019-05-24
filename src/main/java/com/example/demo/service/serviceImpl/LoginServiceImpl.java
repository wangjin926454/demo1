package com.example.demo.service.serviceImpl;

import com.example.demo.dao.LoginDAO;
import com.example.demo.entity.LoginInfo;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
    @Resource
    private LoginDAO loginDAO;

    @Override
    public List<LoginInfo> login(LoginInfo info) {
        return loginDAO.login(info);
    }

    @Override
    public List<LoginInfo> adminLogin(LoginInfo info) {
        return loginDAO.adminLogin(info);
    }

    @Override
    public LoginInfo select(String userName) {
        return loginDAO.select(userName);
    }
}