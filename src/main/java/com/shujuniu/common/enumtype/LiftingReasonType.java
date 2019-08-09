package com.shujuniu.common.enumtype;


public enum LiftingReasonType {
    NORMAL((byte)0,"正常出场"),
    SYSTEM_FAILURE((byte)1,"系统故障"),
    ABNORMAL_APPEARANCE((byte)2,"异常出场"),
    UNLICENSED_APPEARANCE((byte)3,"无牌出场");

    private byte type;

    private String message;
    LiftingReasonType(byte type,String message){
        this.type = type;
        this.message = message;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessageByType(Byte type){
        if(type == null){
            return null;
        }
        LiftingReasonType[] liftingReasonTypes = LiftingReasonType.values();

        for(LiftingReasonType liftingReasonType : liftingReasonTypes){
            if(type == liftingReasonType.getType()){
                return liftingReasonType.getMessage();
            }
        }
        return "";
    }
}
