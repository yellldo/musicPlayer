package com.music.player.framework.common.utils;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * ClassName : HttpContextUtil<br>
 * Description : HttpContextUtil<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public class HttpContextUtil {

    public HttpContextUtil() {

    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static String getHeaderByName(String name) {
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        return httpServletRequest.getHeader(name);
    }
}
