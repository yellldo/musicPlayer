package com.music.player.framework.trace.utils;

import cn.hutool.core.util.IdUtil;


/**
 * ClassName : TraceIdUtil<br>
 * Description : TraceIdUtil<br>
 *
 * @author : sj
 * @date : 1/14/26
 */
public class TraceIdUtil {

    public static String generateTraceId() {
        return IdUtil.fastSimpleUUID();
    }
}
