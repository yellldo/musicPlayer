package com.music.player.framework.common.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * ClassName : Constant<br>
 * Description : Constant常量类<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public class Constant {

    public static List<String> EXCLUDE_STATIC_PATTERNS = Lists.newArrayList(
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/swagger/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/**/*.js",
            "/**/*.css",
            "/**/*.png",
            "/**/*.ico",
            "/favicon.ico",
            "/webjars/**",
            "/doc.html",
            "/actuator/**"
    );
}
