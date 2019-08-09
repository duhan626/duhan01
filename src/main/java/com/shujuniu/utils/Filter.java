package com.shujuniu.utils;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
public class Filter {

   /**

     * 过滤字母

     * @param alphabet

     * @return

     */

    public static String filterAlphabet(String alphabet){

        return alphabet.replaceAll("[A-Za-z]", "");

    }



    /**

     * 过滤数字

     * @param digital

     * @return

     */

    public static String filterDigital(String digital){

        return digital.replaceAll("[0-9]", "");

    }



    /**

     * 过滤汉字

     * @param chin

     * @return

     */

    public static String filterChinese(String chin){

        return chin.replaceAll("[\\u4e00-\\u9fa5]", "");

    }



    /**

     * 过滤 字母、数字、汉字

     * @param character

     * @return

     */

    public static String filterAll(String character){

        return character.replaceAll("[a-zA-Z0-9\\u4e00-\\u9fa5]", "");

    }

/**
 *  判断是否有汉字
 */


public static boolean isLetterDigitOrChinese(String str) {
//        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
    String regex = "[\\u4e00-\\u9fa5]";
    return str.matches(regex);
}

    /**

     * @param args

     */

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        String  str = "hello423你好吗,我很好 4thank you44f";

        String reg = "[\u2E80-\u9FFF]";

        Pattern pat = Pattern.compile(reg);

        Matcher mat = pat.matcher(str);
        System.out.println("过滤 "+mat);
        String repickStr = mat.replaceAll("");

        System.out.println("过滤中文后: "+repickStr);



        System.out.println("-----------------");



        System.out.println("过滤字母:"+filterAlphabet("123abc你好"));

        System.out.println("过滤数字："+filterDigital("123abc你好"));

        System.out.println("过滤汉字："+filterChinese("123abc你好"));

        System.out.println("过滤字母、数字、汉字:"+filterAll("123abc你好"));

        System.out.println("判断是否汉字:"+isLetterDigitOrChinese("你好"));

    }



}
