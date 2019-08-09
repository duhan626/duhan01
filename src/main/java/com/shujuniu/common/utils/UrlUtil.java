package com.shujuniu.common.utils;

import com.google.common.base.Strings;
import org.apache.catalina.util.URLEncoder;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

import static java.lang.Character.UnicodeBlock.*;

/**
 * Created by zhanghw on 2017/10/19.
 */
public class UrlUtil {

    private static Logger logger = LoggerFactory.getLogger(UrlUtil.class);

    /**
     * 针对url中的中文参数值作编码
     *
     * @param url
     * @return
     */
    public static String encodeUrlChineseParamValue(String url) {

        try {

            if (url == null) {
                return url;
            }

            String resultUrl = url;

            int indexValue = resultUrl.indexOf("?");


            if (indexValue > 0) {

                String prePath = resultUrl.substring(0, indexValue + 1);
                String paramPath = resultUrl.substring(indexValue + 1, resultUrl.length());

                String[] arrSplit = paramPath.split("&");
                StringBuffer paramTemp = new StringBuffer();
                String paramValue = null;
                URLEncoder uRLEncoder = new URLEncoder();

                for (int idx = 0, size = arrSplit.length; idx < size; idx++) {

                    String[] arrSplitEqual = arrSplit[idx].split("[=]");

                    //解析出键值
                    if (arrSplitEqual.length > 1) {
                        paramValue = arrSplitEqual[1];

                        //针对中文进行编码
                        if (checkStringContainChinese(paramValue)) {
                            paramValue = uRLEncoder.encode(paramValue, "GBK");

                        }

                        if (idx > 0) {
                            paramTemp.append("&");
                        }

                        paramTemp.append(arrSplitEqual[0] + "=" + paramValue);
                    }
                }

                resultUrl = prePath + paramTemp.toString();

                return resultUrl;
            }


        } catch (Exception ex) {
            logger.error("针对url中的参数值作编码异常,url={},异常信息={}", url, ExceptionUtils.getFullStackTrace(ex));
        }

        return url;
    }

    /**
     * 判断字符串是否包含中文
     *
     * @param checkStr
     * @return
     */
    public static boolean checkStringContainChinese(String checkStr) {
        try {

            if (!Strings.isNullOrEmpty(checkStr)) {
                char[] checkChars = checkStr.toCharArray();
                for (int i = 0, size = checkChars.length; i < size; i++) {
                    char checkChar = checkChars[i];
                    if (checkCharContainChinese(checkChar)) {
                        return true;
                    }
                }
            }

        } catch (Exception ex) {
            logger.error(MessageFormat.format("判断字符是否包含中文,checkChar={0},异常信息={1}", checkStr, ExceptionUtils.getFullStackTrace(ex)));
        }

        return false;
    }

    /**
     * 判断字符是否包含中文
     *
     * @param checkChar
     * @return
     */
    public static boolean checkCharContainChinese(char checkChar) {
        try {
            Character.UnicodeBlock ub = Character.UnicodeBlock.of(checkChar);
            if (CJK_UNIFIED_IDEOGRAPHS == ub || CJK_COMPATIBILITY_IDEOGRAPHS == ub || CJK_COMPATIBILITY_FORMS == ub ||
                    CJK_RADICALS_SUPPLEMENT == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == ub) {
                return true;
            }
        } catch (Exception ex) {
            logger.error(MessageFormat.format("判断字符是否包含中文,checkChar={0},异常信息={1}", checkChar, ExceptionUtils.getFullStackTrace(ex)));
        }
        return false;
    }

    /**
     * url添加参数
     *
     * @param url
     * @param name
     * @param value
     * @return
     */
    public static String urlAppendParam(String url, String name, String value) {

        if (url == null) {
            return null;
        }
        URLEncoder uRLEncoder = new URLEncoder();
//        if (url.indexOf("?") < 0) {
//            url += "?";
//        }
//
//        if (url.indexOf("=") < 0) {
//            url += (name + "=" + value);
//        } else {
//            url += ("&" + name + "=" + value);
//        }
        if (url.indexOf("?") < 0) {
            //针对中文进行编码
            if (checkStringContainChinese(value)) {
                value = uRLEncoder.encode(value);
            }
            url += ("?" + name + "=" + value);
        } else {
            //针对中文进行编码
            if (checkStringContainChinese(value)) {
                value = uRLEncoder.encode(value);
            }
            url += ("&" + name + "=" + value);
        }
        return url;
    }
}
