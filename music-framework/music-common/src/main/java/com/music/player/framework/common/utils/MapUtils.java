package com.music.player.framework.common.utils;

import com.google.common.collect.Maps;
import com.music.player.framework.common.core.KeyValue;

import java.util.List;
import java.util.Map;

/**
 * ClassName : MapUtils<br>
 * Description : Map 工具类<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
public class MapUtils {

    public static <K, V> Map<K, V> convertMap(List<KeyValue<K, V>> keyValues) {
        Map<K, V> map = Maps.newLinkedHashMapWithExpectedSize(keyValues.size());
        keyValues.forEach(keyValue -> map.put(keyValue.getKey(), keyValue.getValue()));
        return map;
    }
}
