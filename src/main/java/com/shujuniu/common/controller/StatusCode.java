package com.shujuniu.common.controller;

public enum StatusCode {

    SUCCESS(10000,"服务调用成功"),
    ERROR(20000,"服务不可用"), //出现异常
    NO_LOGIN(20001,"请重新登录"),
    AUTH_LIMIT(20002,"授权权限不足"),
    DATA_NULL(20003,"数据为空"),
    DATA_ERROR(20004,"数据异常"),
    PARAMETER_LOSE(40001,"缺少必选参数"),
    PARAMETER_INVALID(40002,"非法的参数"),
    INPUT_STREAM_EMPTY(50001,"输入流为空"),
    PROGRAM_EXCEPTION(50002,"程序异常"),
    SMS_CODE_SEND_TOO_FAST(60001,"操作频繁，请稍后重试");


    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
