package com.shujuniu.common.rest;

import java.lang.annotation.*;

/**
 * 用户操作日志
 * Created by haiwei on 2018/8/23.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface MRPUserOperateLog {

    //接口说明
    String interfaceName();
}
