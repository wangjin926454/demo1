package com.example.demo.service.serviceImpl;

import com.example.demo.dao.SelectMyUsers;
import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.SelectMyUsersInfo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.SelectMyUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectMyUsersImpl implements SelectMyUsersService {
    @Resource
    SelectMyUsers selectMyUsers;

    @Override
    public List<SelectMyUsersInfo> selectMyUsers(SelectMyUsersInfo selectMyUsersInfo) {
        return selectMyUsers.selectMyUsers(selectMyUsersInfo);
    }

    @Override
    public int selectMyUsers1() {
        return selectMyUsers.selectMyUsers1();
    }

    @Override
    public List<SelectMyUsersInfo> selectAllUsers() {
        return selectMyUsers.selectAllUsers();
    }

    @Override
    public List<SelectMyUsersInfo> search(SelectMyUsersInfo usersInfo) {
        return selectMyUsers.searchUser(usersInfo);
    }

    @Override
    public List<UserInfo> selectAll(UserInfo usersInfo) {
        return selectMyUsers.selectAll(usersInfo);
    }

    @Override
    public List<UserInfo> selectUsers() {
        return selectMyUsers.selectUsers();
    }

    @Override
    public List<EmailInfo> selectSended() {
        return selectMyUsers.selectSended();
    }
}
