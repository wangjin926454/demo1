package com.example.demo.service;

import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.FileInfo;
import com.example.demo.entity.SelectInfo;

public interface InsertMyInfoService {
    int insertMyInfo(SelectInfo info);
    int insertMyInfo1(SelectInfo info);

    int uploadFile(FileInfo fileInfo);

    int insertEmail(EmailInfo info);
}
