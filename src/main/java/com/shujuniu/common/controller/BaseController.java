package com.shujuniu.common.controller;


import com.alibaba.fastjson.JSON;
import com.shujuniu.common.AdminMRPContext;
import com.shujuniu.common.exception.MRPException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.text.MessageFormat;
import java.util.ArrayList;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

@Slf4j
public abstract  class BaseController {


    protected static final String API_TOKEN_MUST = "需要先登录，token必传";

    protected static final String API_TOKEN_NOT_MUST = "token可不传";

    protected static final String GET = "GET";
    protected static final String POST = "POST";


    // 必须是个常量
    protected  final int API_SUCCESS_CODE =  200;//StatusCode.SUCCESS.getErrCode();
    protected  final String API_SUCCESS_MESSAGE = "调用成功"; //StatusCode.SUCCESS.getMsg();

    public void setOperateDataId(Integer dataId){
        AdminMRPContext.getContext().setDataId(dataId);
    }

    public String handlerObjectResult(Object data){
        ApiResult result = new ApiResult();
        result.setValue( data == null ? new Object() : data);
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getMessage());
        result.setSubMessage("操作成功");
        return  JSON.toJSONString(result);
    }

    public String handlerListResult(Object data,Integer type){
        ApiResult result = new ApiResult();
        result.setValue( data == null ? new ArrayList<>() : data);
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getMessage());
        result.setSubMessage("操作成功");
        if(type == 1){
            return  JSON.toJSONString(result,WriteMapNullValue);
        }
        return  JSON.toJSONString(result);
    }


    public String handlerException(Exception ex,String interfaceName){
        if(ex instanceof MRPException){
            return handlerMRPException((MRPException)ex,interfaceName,null);
        }

        log.error("接口出现异常："+ interfaceName +  "\n" +ExceptionUtils.getFullStackTrace(ex));
        ApiResult apiResult = new ApiResult();
        apiResult.setValue(new Object());
        apiResult.setMessage("出现异常");
        apiResult.setSubMessage("操作失败");
        return  JSON.toJSONString(apiResult);
    }


    public String handlerException(Exception ex,String interfaceName,Object... paramValue){

        if(ex instanceof MRPException){
            return handlerMRPException((MRPException)ex,interfaceName,paramValue);
        }
        log.error("接口出现异常：接口描述【{}】，入参=【{}】"
                , getParamValueStringValue(paramValue) ,
                ExceptionUtils.getFullStackTrace(ex));
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(StatusCode.ERROR.getCode());
        apiResult.setMessage("出现异常");
        apiResult.setSubMessage("操作失败");
        return  JSON.toJSONString(apiResult);
    }


    public String handlerMRPException(MRPException ex, String interfaceName, Object... paramValue){
        log.error(MessageFormat.format("接口出现异常：接口说明【{0}】，入参=【{1}】，异常说明=【{2}】",
                interfaceName,
                getParamValueStringValue(paramValue),
                ExceptionUtils.getFullStackTrace(ex)));

        ApiResult apiResult = new ApiResult();
        apiResult.setMessage(ex.getStatusCode().getMessage());
        apiResult.setCode(ex.getStatusCode().getCode());
        apiResult.setSubMessage(ex.getBusinessMessage());
        return JSON.toJSONString(apiResult);
    }

    protected static String getParamValueStringValue(Object... paramValue){
        if(paramValue == null || paramValue.length <= 0){
            return "";
        }

        StringBuffer result = new StringBuffer();

        for(int idx = 0 ,size = paramValue.length; idx < size; idx++){
            if(paramValue[idx] == null){
                result.append(String.format("param_%d=null，",idx));
                continue;
            }
            result.append(String.format("param_%d=%s，",idx,paramValue[idx].toString()));
        }

        return result.toString();
    }


  /*   * 获取当前登录用户的用户ID
     * @return*/


    public Integer getLoginUserId() {
        Integer userId = AdminMRPContext.getContext().getUserId();
        if(userId == null || userId.intValue() <= 0){
            throw new MRPException(StatusCode.NO_LOGIN, "获取不到登录用户");
        }
        return userId;
    }
}
