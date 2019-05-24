package com.example.demo.dao;

import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.SelectMyUsersInfo;
import com.example.demo.entity.UserInfo;

import java.util.List;

public interface SelectMyUsers {
    List<SelectMyUsersInfo> selectMyUsers(SelectMyUsersInfo selectMyUsersInfo);
    int selectMyUsers1();
    List<SelectMyUsersInfo> selectAllUsers();

    List<SelectMyUsersInfo> searchUser(SelectMyUsersInfo usersInfo);

    List<UserInfo> selectAll(UserInfo usersInfo);

    List<UserInfo> selectUsers();

    List<EmailInfo> selectSended();
}
