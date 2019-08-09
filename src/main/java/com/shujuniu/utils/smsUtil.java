package com.shujuniu.utils;

import com.google.common.base.Splitter;

import java.util.List;

public class smsUtil {

    public static void setPackages(String s) {
        String[] mb = s.split("|", s.length());
        for (int i = 0; i < mb.length; i++) {

            System.out.println(mb[i]);
        }

    }

    public static void main(String[] args) {
        String url = "131000000,北京,北京|13210123456,河北,唐山|1321032333,广东,中山|13810366355,天津,天津|13650366355,天津,天津";
//        String url = "1381023333|";
        if (url.indexOf("|") > 0) {

            splitMethod2(url);
        } else {
            System.out.println("走单号码");
        }

    }

    private static final String SPLIT_CHAR = "|";


    private static void splitMethod2(String str) {
        if (str.indexOf("|") > 1) {
            List<String> strList = Splitter.on(SPLIT_CHAR).splitToList(str);
            System.out.println("strList:" + strList);
            for (int i = 0; i < strList.size(); i++) {
                String firstStr = strList.get(i);
                List<String> minList = Splitter.on(",").splitToList(firstStr);
                System.out.println("minList phone:" + minList.get(0) + " " + "minList p:" + minList.get(1) + " " + "minList c:" + minList.get(2));

            }
        }
    }

}
