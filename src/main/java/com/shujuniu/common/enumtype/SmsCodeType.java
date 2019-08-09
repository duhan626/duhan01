package com.shujuniu.common.enumtype;

/**
 * 短信验证码类型
 * @author : WuWei on 2018 09 13
 * @version : 1.0
 **/
public enum SmsCodeType {

    WX_REGISTER(1);             // 注册发送验证码

    private int value;

    SmsCodeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SmsCodeType parseInt(int value) {
        for (SmsCodeType enumItem : SmsCodeType.values()) {
            if (enumItem.getValue() == value) {
                return enumItem;
            }
        }
        return null;
    }

    public static boolean contains(int value) {
        return parseInt(value) != null;
    }
}
