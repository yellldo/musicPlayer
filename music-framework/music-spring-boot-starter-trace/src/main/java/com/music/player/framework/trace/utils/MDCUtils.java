package com.music.player.framework.trace.utils;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * ClassName : MDCUtils<br>
 * Description : MDCUtils<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
public class MDCUtils {

    /**
     * 获取当前线程的 MDC 副本
     */
    public static Map<String, String> getCopyOfContextMap() {
        return MDC.getCopyOfContextMap();
    }

    /**
     * 设置 MDC 上下文
     */
    public static void setContextMap(Map<String, String> context) {
        if (context != null) {
            MDC.setContextMap(context);
        }
    }

    /**
     * 清空 MDC
     */
    public static void clear() {
        MDC.clear();
    }

    /**
     * 包装 Runnable，保留 MDC
     */
    public static Runnable wrap(Runnable runnable) {
        Map<String, String> context = getCopyOfContextMap();
        return () -> {
            setContextMap(context);
            try {
                runnable.run();
            } finally {
                clear();
            }
        };
    }

    /**
     * 包装 Callable
     */
    public static <T> Callable<T> wrap(Callable<T> callable) {
        Map<String, String> context = getCopyOfContextMap();
        return () -> {
            setContextMap(context);
            try {
                return callable.call();
            } finally {
                clear();
            }
        };
    }
}
