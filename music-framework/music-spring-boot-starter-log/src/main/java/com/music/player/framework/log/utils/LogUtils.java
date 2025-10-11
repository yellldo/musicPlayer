package com.music.player.framework.log.utils;


import com.music.player.framework.log.annoatation.HttpRequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * ClassName : LogUtils<br>
 * Description : LogUtils<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
public class LogUtils {

    public LogUtils() {

    }

    public static HttpRequestLog getHttpRequestLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(HttpRequestLog.class);
    }

}
