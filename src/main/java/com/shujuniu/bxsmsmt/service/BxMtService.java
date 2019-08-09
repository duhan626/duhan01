package com.shujuniu.bxsmsmt.service;

import com.shujuniu.bxsmsmt.dto.BxMtDto;
import com.shujuniu.bxsmsmt.po.BxMTDao;


/**
 * Created by LuoBin 2019/6/30 10:29
 */

public interface BxMtService {

    /**
     * 从渠道提交-存储过程提交-插B库mt表
     */
    String insetTMT(BxMtDto dto);

    /**
     * 提交给联通开放平台-更新MT状态为0
     */
    boolean updateTMTBySubmit(BxMTDao dao);

    /**
     * 接收联通开放平台-更新MT状态为DELiVED
     */

    BxMTDao  getMtDataList(String msgId);
}
