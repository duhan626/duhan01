package com.shujuniu.common.enumtype;

import com.shujuniu.common.controller.StatusCode;
import com.shujuniu.common.exception.MRPException;

import java.util.Arrays;

public enum FilePathConstants {

    ENTRY_IMAGE("entry_image" , "images/record/entry/"),
    OUT_IMAGE("out_image" , "images/record/out/");

    private String serviceName;

    private String filePath;

    FilePathConstants(String serviceName , String filePath){
        this.serviceName = serviceName;
        this.filePath = filePath;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getFilePath() {
        return filePath;
    }

    public static String valueof(final String serviceName) throws MRPException{
        FilePathConstants[] filePathConstants = FilePathConstants.values();
        System.out.println(Arrays.toString(filePathConstants));
        for(FilePathConstants filePathConstants1 : filePathConstants){
            if(filePathConstants1.getServiceName().equalsIgnoreCase(serviceName)){
                return filePathConstants1.getFilePath();
            }
        }
        throw new MRPException(StatusCode.PARAMETER_INVALID);
    }

}
