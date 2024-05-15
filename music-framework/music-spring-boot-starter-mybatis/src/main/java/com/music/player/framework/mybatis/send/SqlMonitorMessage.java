package com.music.player.framework.mybatis.send;

import com.music.player.framework.mybatis.plugins.SlowSqlMonitorInterceptor;
import lombok.Data;

/**
 * ClassName : SqlMonitorMessage<br>
 * Description : SqlMonitorMessage<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@Data
public class SqlMonitorMessage {

    /**
     * 监控类型
     */
    private SlowSqlMonitorInterceptor.Type type;

    /**
     * sqlId
     */
    private String sqlId;

    /**
     * sql
     */
    private String sql;

    /**
     * 异常信息
     */
    private String exceptionMsg;

    /**
     * 方法调用堆栈
     */
    private String stackTrace;

    /**
     * 检测耗时
     */
    private long checkTime;

    /**
     * 执行耗时
     */
    private long executeTime;
}
