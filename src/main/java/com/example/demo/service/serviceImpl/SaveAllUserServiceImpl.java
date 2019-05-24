package com.example.demo.service.serviceImpl;

import com.example.demo.dao.SaveAllUserDao;
import com.example.demo.entity.*;
import com.example.demo.service.SaveAllUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaveAllUserServiceImpl implements SaveAllUserService {
    @Resource
    SaveAllUserDao dao;
    @Override
    public int savaAllUser(SelectMyUsersInfo usersInfo) {
        return dao.saveAllUser(usersInfo);
    }

    @Override
    public int deleteUser(SelectMyUsersInfo usersInfo) {
        return dao.deleteUser(usersInfo);
    }

    @Override
    public int createUser(SelectMyUsersInfo usersInfo) {
        return dao.createUser(usersInfo);
    }

    @Override
    public int saveMessage(MessageInfo messageInfo) {
        return dao.saveMessage(messageInfo);
    }

    @Override
    public int deleteUser1(UserInfo usersInfo) {
        return dao.deleteUser1(usersInfo);
    }

    @Override
    public int saveSave1(UserInfo usersInfo) {
        return dao.saveSave1(usersInfo);
    }

    @Override
    public int saveUser11(UserInfo usersInfo) {
        return dao.saveUser11(usersInfo);
    }

    @Override
    public int delectDingdanByID(DingdanInfo info) {
        return dao.delectDingdanByID(info);
    }

    @Override
    public int updateDingdanByID(DingdanInfo info) {
        return dao.updateDingdanByID(info);
    }

    @Override
    public int saveNewGoodType(TypeInfo info) {
        return dao.saveNewGoodType(info);
    }

    @Override
    public int saveNewDingdan(DingdanInfo info) {
        return dao.saveNewDingdan(info);
    }
}
