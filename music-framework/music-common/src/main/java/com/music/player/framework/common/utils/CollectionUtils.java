package com.music.player.framework.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName : CollectionUtils<br>
 * Description : CollectionUtils<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
public class CollectionUtils {

    public static <T, U> List<U> convertList(T[] from, Function<T, U> func) {
        if (ArrayUtil.isEmpty(from)) {
            return new ArrayList<>();
        }
        return convertList(Arrays.asList(from), func);
    }

    public static <T, U> List<U> convertList(Collection<T> from, Function<T, U> func) {
        if (CollUtil.isEmpty(from)) {
            return new ArrayList<>();
        }
        return from.stream().map(func).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
