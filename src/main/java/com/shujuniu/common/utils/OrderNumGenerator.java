package com.shujuniu.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单号生成工具类
 * Created by haiwei on 2018/8/15.
 */
public class OrderNumGenerator {


    /**
     * 生成快喷单号
     */
    public static String generateFlowCode() {
        // 年月日时分秒+4位时间戳随机数
        String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random rand = new Random();
        String code = String.format("%s%d%d%d%d",curTime,rand.nextInt(9),rand.nextInt(9),rand.nextInt(9),rand.nextInt(9));
        return code;
    }

    /**
     * 生成销售单号（MRP系统生成）
     *
     * @return
     */
    public static String generateSaleOrderCode(String key){
        Random random = new Random(Long.parseLong(key));
        String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return String.format("%s%d%d%d%d",curTime,random.nextInt(9),random.nextInt(9),random.nextInt(9),random.nextInt(9));
    }

    public static String generateTrafficCode() {
        // 年月日时分秒+4位时间戳随机数
        String curTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random rand = new Random();
        String code = String.format("%s%d%d%d",curTime,rand.nextInt(9),rand.nextInt(9),rand.nextInt(9));
        return code;
    }

//
//    public static void main(String[] args){
//        String code = OrderNumGenerator.generateFlowCode();
//        System.out.println(code);
//
//        String flowCode = OrderNumGenerator.generateTrafficCode();
//        System.out.println(flowCode);
//
//    }

}
