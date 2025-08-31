package com.music.player.framework.common.utils;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Pattern;

/**
 * ClassName : ValidationUtils<br>
 * Description : 校验工具类<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
public class ValidationUtils {


    private static final Pattern PATTERN_MOBILE = Pattern.compile("^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[0,1,4-9])|(?:5[0-3,5-9])|(?:6[2,5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[0-3,5-9]))\\d{8}$");
    private static final Pattern PATTERN_EMAIL = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static boolean isMobile(String mobile) {
        return StrUtil.isNotEmpty(mobile)
                && PATTERN_MOBILE.matcher(mobile).matches();
    }


    public static boolean isEmail(String email) {
        return StrUtil.isNotEmpty(email) &&
                PATTERN_EMAIL.matcher(email).matches();
    }

}
