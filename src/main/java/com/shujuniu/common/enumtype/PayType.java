package com.shujuniu.common.enumtype;
public enum PayType {
    ENTRY("0","pos"),
    OUT("1","现金"),
    ALIPAY("alipay","支付宝"),
    WXPAY("wxpay","微信"),
    JDPAY("jdpay","京东POS刷卡");

    PayType(String type,String name){
        this.name = name;
        this.type = type;
    }
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByType(String type){
        PayType[] payTypes = PayType.values();

        for(PayType payType : payTypes){
            if(type.equals(payType.getType())){
                return payType.getName();
            }
        }
        return "";
    }
}
