package com.shujuniu.common.enumtype;

public enum BusinessType {
    ADMINISTRATION((byte)0,"行政"),
    SALE((byte)1,"新车销售"),
    AFTER_SALE((byte)2,"售后");
    private byte code;
    private String message;

    BusinessType(byte code ,String message){
        this.code = code;
        this.message = message;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static boolean getAfterSale(byte code){
        if(code == BusinessType.AFTER_SALE.code){
            return true;
        }
        return false;
    }
    public static BusinessType getType(Byte code){
        if(code == null){
            return null;
        }
        for(BusinessType enums:BusinessType.values()){
            if(enums.code == code){
                return enums;
            }
        }
        return null;
    }

    public static  String getName(Byte code){
        if(code == null){
            return null;
        }
        for(BusinessType enums:BusinessType.values()){
            if(enums.code == code){
                return enums.message;
            }
        }
        return null;
    }
}
