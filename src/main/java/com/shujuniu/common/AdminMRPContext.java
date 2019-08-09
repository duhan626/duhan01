package com.shujuniu.common;

import lombok.Data;

@Data
public class AdminMRPContext {

    private static final ThreadLocal<AdminMRPContext> LOCAL = new ThreadLocal<AdminMRPContext>() {
        @Override
        protected AdminMRPContext initialValue() {
            return new AdminMRPContext();
        }
    };

    protected AdminMRPContext() {

    }

    public static AdminMRPContext getContext() {
        return LOCAL.get();
    }

    private String token;


    private Integer userId;

    private Integer dataId;
}
