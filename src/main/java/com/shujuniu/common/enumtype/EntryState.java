package com.shujuniu.common.enumtype;

public enum EntryState {
    PENDING_APPLY((byte)0,"待申请"),
    CHECK_PENDING((byte)1,"待审核"),
    AUDIT_PASS((byte)2,"审核通过"),
    AUDIT_REJECT((byte)3,"审核拒绝"),
    ALREADY_APPEARED((byte)4,"已出场");

    private byte code;
    private String message;

    EntryState(byte code, String message) {
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

    public static EntryState getType(byte type){
        for(EntryState enums:EntryState.values()){
            if(enums.code == type){
                return enums;
            }
        }
        return null;
    }
}
