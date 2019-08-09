package com.shujuniu.common.enumtype;

public enum ReleaseType {
    PASS(1,"是"),
    FAIL(0,"否");
    private int id;
    private String name;
    ReleaseType(int id , String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isRelease(Byte id){
        if(id == null){
            return false;
        }
        return id.intValue() == 1;
    }
    public static String getName(Byte type){
        ReleaseType[] releaseTypes = ReleaseType.values();

        for(ReleaseType releaseType : releaseTypes){
            if(type == releaseType.getId()){
                return releaseType.getName();
            }
        }
        return "";
    }
}
