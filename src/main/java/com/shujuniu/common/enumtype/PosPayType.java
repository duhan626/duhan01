package com.shujuniu.common.enumtype;

public enum PosPayType {
    SUCCESS(1,"成功"),
    ERROR(0,"验证签名失败"), //出现异常
    ORDER_NOT_EXIST(-1,"订单不存在"),
    ORDER_PAID(-2,"订单已支付"),
    ORDER_EXPIRED(-3,"订单已过期"),
    ORDER_CANCELLED(-4,"订单已取消"),
    ERROR_PARAMETER(-5,"缺少参数,请检查参数名称"),
    PARAMETER_NULL(-6,"参数值为空");
    private int code;
    private String message;
    PosPayType(int code, String message) {
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
