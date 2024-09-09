package com.music.player.framework.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName : TokenUtil<br>
 * Description : TokenUtil<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public class TokenUtil {

    public static String getToken(HttpServletRequest request) {
        final String requestHeader = request.getHeader("Authorization");
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            return requestHeader.substring(7);
        }
        return null;
    }
}
