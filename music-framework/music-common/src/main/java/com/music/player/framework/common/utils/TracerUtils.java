package com.music.player.framework.common.utils;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;

/**
 * ClassName : TracerUtils<br>
 * Description : 链路追踪工具类
 * <p>
 * 考虑到每个 starter 都需要用到该工具类，所以放到 common 模块下的 util 包下<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
public class TracerUtils {

    /**
     * 私有化构造方法
     */
    private TracerUtils() {
    }

    /**
     * 获得链路追踪编号，直接返回 SkyWalking 的 TraceId。
     * 如果不存在的话为空字符串！！！
     *
     * @return 链路追踪编号
     */
    public static String getTraceId() {
        return TraceContext.traceId();
    }
}
