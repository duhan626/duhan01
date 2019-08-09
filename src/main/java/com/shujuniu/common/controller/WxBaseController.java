package com.shujuniu.common.controller;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract  class WxBaseController extends BaseController{


//    /**
//     * 获取当前登录客户的ID
//     * @return
//     */
//    public Integer getLoginUserId() {
//        Integer custId = WeixinMRPContext.getContext().getCustId();
//        if(custId == null || custId.intValue() <= 0){
//            throw new MRPException(StatusCode.NO_LOGIN, "获取不到登录客户");
//        }
//        return custId;
//    }
//
//    public String getLoginOpenId(){
//        String openId = WeixinMRPContext.getContext().getOpenId();
//        if(StringUtils.isEmpty(openId)){
//            throw new MRPException(StatusCode.NO_LOGIN, "获取不到登录客户");
//        }
//        return openId;
//    }
}
