package com.shujuniu.common.controller;

import lombok.Data;

@Data
public class ApiResult<T> {

    private T value;
    private String message;
    private Integer code;
    private String subMessage;

}