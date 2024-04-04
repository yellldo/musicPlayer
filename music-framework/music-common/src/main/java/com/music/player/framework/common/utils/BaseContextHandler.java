package com.music.player.framework.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : BaseContextHandler<br>
 * Description : BaseContextHandler<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
public class BaseContextHandler {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();

    public static void set(String key, Object value) {
        Map<String, Object> map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap<>(16);
            threadLocal.set(map);
        }
        ((Map) map).put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap(16);
            threadLocal.set(map);
        }

        return ((Map) map).get(key);
    }
}
