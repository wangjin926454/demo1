package com.example.demo.dao;

import com.example.demo.entity.*;

import java.util.List;

public interface SelectInfoDao {
    SelectInfo selectInfo(SelectInfo info);
    SelectInfo selectInfo1(SelectInfo info);

    List<FileInfo> selectFile();

    List<MessageInfo> selectMessage();

    EmailInfo selectEmailByID(EmailInfo info);

    List<DingdanInfo> selectAllDingdan();

    List<TypeInfo> selectGoodsType();

    List<TypeInfo> selectCname();

    DingdanInfo selectDingdanInfoByID(DingdanInfo info);

    List<DingdanInfo> selectMyDingdan(DingdanInfo info);

    List<DingdanInfo> selectState0Dingdan();

    List<Tongji> selectSumMoney();

    List<Tongji> selectYearSumMoney();
}
