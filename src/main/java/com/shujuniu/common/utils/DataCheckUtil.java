package com.shujuniu.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 数据权限校验
 * Created by haiwei on 2018/9/7.
 */
public class DataCheckUtil {

    private static final String MOBILE_PATTERN = "^[1][3,4,5,7,8][0-9]{9}$";

    private static final String CODE_PATTERN = "^[a-zA-Z][a-zA-Z0-9]+$";

    private static final  String PASS_PATTERN = "^([a-zA-Z0-9]|[!@#$%^&*¥(),.，。)]){6,}$";

    private static final String CARNUM_PATTERN ="(?i)^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";

    private static final String VIN_PATTERN = "^([A-Za-z0-9]{17})$";

    private static boolean match(String text, String pattern) {
        return text.matches(pattern);
    }

    /**
     * 校验手机号
     * @param mobile
     * @return
     */
    public static boolean isValidMobile(String mobile){
        if(StringUtils.isEmpty(mobile)){
            return false;
        }
        return match(mobile, MOBILE_PATTERN);
    }

    public static boolean isValidCode(String userCode){
        if(StringUtils.isEmpty(userCode)){
            return false;
        }
        return match(userCode, CODE_PATTERN);
    }

    public static boolean checkVin(String vin){
        if(StringUtils.isEmpty(vin)){
            return false;
        }
        return match(vin, VIN_PATTERN);
    }
    /**
     * 校验车牌号
     * @param carNumber
     * @return
     */
    public static boolean checkCarNum(String carNumber){
        if(StringUtils.isEmpty(carNumber)){
            return false;
        }
        if(carNumber.length() <= 10 && carNumber.length() >= 6){
            return true;
        }
//        if(carNumber.length() == 7 || carNumber.length() == 8){
//           return match(carNumber, CARNUM_PATTERN);
//        }
        //todo 其他规则

        return false;
    }
    /**
     * 校验密码
     * @param pass
     * @return
     */
    public static boolean checkPass(String pass){
        if(StringUtils.isEmpty(pass)){
            return false;
        }
        return match(pass, PASS_PATTERN);
    }


    /**
     * 校验名称（通用），必须大于3位。
     * @param pass
     * @return
     */
    public static boolean checkName(String pass){
        if(StringUtils.isEmpty(pass)){
            return false;
        }

        //必须大于3位
        if(pass.trim().length() < 3){
            return false;
        }

        return true;
    }



    public static void main(String[] args){
        Byte a=1;

        System.out.println("".toUpperCase());
    }
}
