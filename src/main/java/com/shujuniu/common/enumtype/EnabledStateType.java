package com.shujuniu.common.enumtype;

/**
 * Created by haiwei on 2018/8/16.
 */
public enum EnabledStateType {

    ENABLED((byte)1,"启用"),
    DISABLED((byte)0,"停用");

    private byte id;

    private String name;

    EnabledStateType(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static boolean isEnabled(Byte state){
        if(state == null){
            return false;
        }

        return state.intValue() == 1;
    }

}
