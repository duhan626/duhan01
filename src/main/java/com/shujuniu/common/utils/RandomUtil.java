package com.shujuniu.common.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数工具类
 * @author : WuWei on 2018 09 13
 * @version : 1.0
 **/

public final class RandomUtil {
    final static char[] ALL_LOWER_CHARS = {
            '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',  'j',
            'k', 'l', 'm', 'n',  'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    private RandomUtil() {
    }

    /**
     * 生成 UUID
     *
     * @return UUID
     */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 生成用户登录令牌
     *
     * @return 令牌字符串
     */
    public static String genToken() {
        return uuid();
    }
    /**
     * 产生四位随机数字
     *
     * @return 4 位随机数
     */
    public static String genCodeFour() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1,size = 4-randLength; i <= size; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }
    /**
     * 产生六位随机数字
     *
     * @return 6 位随机数
     */
    public static String genCodeSix() {
        int number = (int) (Math.random() * 900000 + 100000);

        return String.valueOf(number);
    }

    /**
     * 产生 8 位随机数字
     *
     * @return 8位随机数
     */
    public static String genCodeEight() {
        int number = (int) (Math.random() * 90000000 + 10000000);
        return String.valueOf(number);
    }

}
