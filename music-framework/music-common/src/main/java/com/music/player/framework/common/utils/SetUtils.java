package com.music.player.framework.common.utils;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * ClassName : SetUtils<br>
 * Description : SetUtils<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
public class SetUtils {

    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }
}
