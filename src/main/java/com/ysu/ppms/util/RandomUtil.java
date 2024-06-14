package com.ysu.ppms.util;

import java.util.Random;

/**
 * @author Yun
 * @description: 生成随机验证码的工具类
 */
public class RandomUtil {
    /**
     * @description: 生成指定位数的验证码
     * @param: 验证码位数
     * @return: java.lang.String
     */
    public String randomCode(int size){
        String sources = "0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            code.append(sources.charAt(random.nextInt(sources.length())));
        }
        return String.valueOf(code);
    }
}
