package com.example.demo.service.serviceImpl;

import com.example.demo.dao.SelectInfoDao;
import com.example.demo.entity.*;
import com.example.demo.service.SelectInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class SelectInfoServiceImpl implements SelectInfoService {
    @Resource
    private SelectInfoDao dao;
    @Override
    public SelectInfo selectInfo(SelectInfo selectInfo) {
        return dao.selectInfo(selectInfo);
    }
    @Override
    public SelectInfo selectInfo1(SelectInfo selectInfo) {
        return dao.selectInfo1(selectInfo);
    }

    @Override
    public List<FileInfo> selectFile() {
        return dao.selectFile();
    }

    @Override
    public List<MessageInfo> selectMessage() {
        return dao.selectMessage();
    }

    @Override
    public EmailInfo selectEmailByID(EmailInfo info) {
        return dao.selectEmailByID(info);
    }

    @Override
    public List<DingdanInfo> selectAllDingdan() {
        return dao.selectAllDingdan();
    }

    @Override
    public List<TypeInfo> selectGoodsType() {
        return dao.selectGoodsType();
    }

    @Override
    public List<TypeInfo> selectCname() {
        return dao.selectCname();
    }

    @Override
    public DingdanInfo selectDingdanInfoByID(DingdanInfo info) {
        return dao.selectDingdanInfoByID(info);
    }

    @Override
    public List<DingdanInfo> selectMyDingdan(DingdanInfo info) {
        return dao.selectMyDingdan(info);
    }

    @Override
    public List<DingdanInfo> selectState0Dingdan() {
        return dao.selectState0Dingdan();
    }

    @Override
    public List<Tongji> selectSumMoney() {
        return dao.selectSumMoney();
    }

    @Override
    public List<Tongji> selectYearSumMoney() {
        return dao.selectYearSumMoney();
    }
}
