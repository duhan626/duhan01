package com.shujuniu.netty.cmppclient;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import com.shujuniu.gwbmid.mapper.GwBMIDMapper;
import com.shujuniu.gwbmid.po.GwBMIDDao;
import com.shujuniu.gwbmid.service.GwBMIDService;
import com.shujuniu.haod.service.HaodService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
public class Test {

    private final HaodService haodService;
    @Autowired
    private GwBMIDService gwBMIDService;

    @Autowired
    public Test(HaodService haodService, GwBMIDService gwBMIDService) {
        this.haodService = haodService;
        this.gwBMIDService = gwBMIDService;
    }

    private static final String SPLIT_CHAR = "&";

    public static void main(String[] args) {
//
//        String mbstr="13810366355,18600982715,13520250363,1980384432";
//        String[]  mb = mbstr.split(",");
//        for(int i=0;i<mb.length;i++){
//            System.out.println(mb[i]);
//        }

//        String URl1 = "http://39.107.143.16:8081/shujuniu/bxmtsubmittoucopen?bid=7012259242270010100&uid=8249&gwid=267&sc=&p=%B1%B1%BE%A9&c=%B1%B1%BE%A9&pt=1&pu=1&oper=1&mid=b5be23ca970e4630ac74c307fe3b51bf&code=321&emmid=rmb1n2anh8jsvol4mtddsn2uir&appid=29&mb=18600982715";
//        String URl2 = "bid=7031315546040010100&uid=8249&gwid=267&sc=&province=&city=&pt=1&pu=1&oper=1&mid=b5be23ca970e4630ac74c307fe3b51bf&code=b369&emmid=rmb1n2anh8jsvol4mtddsn2uir&appid=29&mb=18610577568";
////        //            System.out.println(URLDecoder.decode(URl1, "GBK"));
//        String p = null;
//        String c = null;
//        if (URl2.contains("&province=&")) {
//            System.out.println("-------------------");
//
//            return;
//        }
//        List<String> strList = Splitter.on(SPLIT_CHAR).splitToList(URl2);
//        System.out.println(strList);
//        for (int i = 0; i < strList.size(); i++) {
//            String firstStr = strList.get(i);
//            if (firstStr.contains("province")) {
//
//                String[] provnice = firstStr.split("=");
//                System.out.println(provnice[0]);
//                System.out.println(provnice[1]);
//                p = provnice[1];
//            }
//
//            if (firstStr.contains("city")) {
//                String[] city = firstStr.split("=");
//                System.out.println(city[1]);
//                c=city[1];
//            }
//        }

//        System.out.printf("p" + p);
//        System.out.printf("c" + c);


//        JSONObject result = new JSONObject();
//        result.put("code","1233addd");
//        System.out.println(result);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dstr = "1900-01-01 00:00:00.000";
//            java.util.Date date = sdf.parse(dstr);
//            System.out.println(sdf.parse(new Date()));

//        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println("当前时间是: " + now);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//        System.out.println("另一种表示形式:" + now.format(formatter));

String st1="【银汉游戏】您此次申请手机注册的验证码：% (30分钟内有效)，如非本人操作，请忽略。";
//String st2="【aiagain】验证码：%，为了您的信息安全，请勿泄露验证码给任何人，30分钟内输入有效。";
//        System.out.println("---------"+st1.substring(0,st1.length()-st1.length()/5));
//if(st1.contains(st2)){
//    System.out.println("包含");
//}else{
//    System.out.println("不包含");
//}

        String number ="中国";
//        if (number.matches("[a-zA-Z0-9_]*")) {
//// do sth.
//            System.out.println(st1.trim());
//        }
        System.out.println( isLetterDigitOrChinese(st1));

        String str1 = "java判断是否为汉字";
        String str2 = "805180#详询";
        String reg = "[\\u4e00-\\u9fa5]+";
        boolean result1 = str1.matches(reg);
        boolean result2 = str2.matches(reg);
        System.out.println("result1:"+result1);
        System.out.printf("result2:"+result2);

        String str = "java怎么把asdasd字符串中的asdasd的汉字取出来";
        String reg1 = "[^\u4e00-\u9fa5]";
        str = str.replaceAll(reg1, " ");
        System.out.println(str);

        boolean result = (str2.length() == str2.getBytes().length);//true:无汉字  false:有汉字
        System.out.printf("result:"+result);
    }

    public static boolean isLetterDigitOrChinese(String str) {
//        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
        String regex = "[\\u4e00-\\u9fa5]";
        return str.matches(regex);
    }



}






