package com.example.demo.dao;

import com.example.demo.entity.*;

public interface SaveAllUserDao {
    int saveAllUser(SelectMyUsersInfo usersInfo);
    int deleteUser(SelectMyUsersInfo usersInfo);

    int createUser(SelectMyUsersInfo usersInfo);

    int saveMessage(MessageInfo messageInfo);

    int deleteUser1(UserInfo usersInfo);

    int saveSave1(UserInfo usersInfo);

    int saveUser11(UserInfo usersInfo);

    int delectDingdanByID(DingdanInfo info);

    int updateDingdanByID(DingdanInfo info);

    int saveNewGoodType(TypeInfo info);

    int saveNewDingdan(DingdanInfo info);
}
