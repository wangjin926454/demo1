package com.example.demo.dao;

import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.FileInfo;
import com.example.demo.entity.SelectInfo;


public interface InsertMyInfo {
    int insertMyinfo(SelectInfo selectInfo);
    int insertMyinfo1(SelectInfo selectInfo);

    int uploadFile(FileInfo fileInfo);

    int insertEmail(EmailInfo info);
}
