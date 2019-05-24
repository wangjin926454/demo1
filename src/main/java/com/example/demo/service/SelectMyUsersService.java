package com.example.demo.service;

import com.example.demo.dao.SelectMyUsers;
import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.SelectMyUsersInfo;
import com.example.demo.entity.UserInfo;

import java.util.List;

public interface SelectMyUsersService {
    List<SelectMyUsersInfo> selectMyUsers(SelectMyUsersInfo selectMyUsersInfo);
    int selectMyUsers1();
    List<SelectMyUsersInfo> selectAllUsers();

    List<SelectMyUsersInfo>  search(SelectMyUsersInfo usersInfo);

    List<UserInfo> selectAll(UserInfo usersInfo);

    List<UserInfo> selectUsers();

    List<EmailInfo> selectSended();
}
