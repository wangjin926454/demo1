package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;

public interface SelectInfoService {
    SelectInfo selectInfo(SelectInfo selectInfo);
    SelectInfo selectInfo1(SelectInfo selectInfo);

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
