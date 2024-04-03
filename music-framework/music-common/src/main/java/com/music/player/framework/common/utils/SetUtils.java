package com.music.player.framework.common.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * ClassName : SetUtils<br>
 * Description : Set 工具类<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
public class SetUtils {

    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }
}
