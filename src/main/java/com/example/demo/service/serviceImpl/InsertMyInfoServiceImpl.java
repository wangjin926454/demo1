package com.example.demo.service.serviceImpl;

import com.example.demo.dao.InsertMyInfo;
import com.example.demo.entity.EmailInfo;
import com.example.demo.entity.FileInfo;
import com.example.demo.entity.SelectInfo;
import com.example.demo.service.InsertMyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class InsertMyInfoServiceImpl implements InsertMyInfoService {
    @Resource InsertMyInfo dao;

    @Override
    public int insertMyInfo(SelectInfo info) {
        return dao.insertMyinfo(info);
    }

    @Override
    public int insertMyInfo1(SelectInfo info) {
        return dao.insertMyinfo1(info);
    }

    @Override
    public int uploadFile(FileInfo fileInfo) {
        return dao.uploadFile(fileInfo);
    }

    @Override
    public int insertEmail(EmailInfo info) {
        return dao.insertEmail(info);
    }
}
