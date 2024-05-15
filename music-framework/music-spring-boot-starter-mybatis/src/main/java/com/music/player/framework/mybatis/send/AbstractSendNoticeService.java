package com.music.player.framework.mybatis.send;

import com.music.player.framework.mybatis.plugins.SlowSqlMonitorInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName : AbstractSendNoticeService<br>
 * Description : 消息通知抽象类<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@Slf4j
public abstract class AbstractSendNoticeService implements SendNoticeService {

    @Override
    public void send(SqlMonitorMessage sqlMonitorMessage) {
        String sqlMsg;
        if (sqlMonitorMessage.getType() == SlowSqlMonitorInterceptor.Type.SLOW_SQL) {
            sqlMsg = String.format("\n慢sql, 执行耗时: [%d]ms，检测耗时：[%d]ms\nSQLId: %s\nSQL语句: %s \n方法调用信息: %s",
                    sqlMonitorMessage.getExecuteTime(), sqlMonitorMessage.getCheckTime(), sqlMonitorMessage.getSqlId(),
                    sqlMonitorMessage.getSql(), sqlMonitorMessage.getStackTrace());
        } else {
            sqlMsg = String.format("\n异常sql, 检测耗时：[%d]ms\nSQLId: %s\nSQL语句: %s \n异常信息: %s \n方法调用信息: %s",
                    sqlMonitorMessage.getCheckTime(), sqlMonitorMessage.getSqlId(), sqlMonitorMessage.getSql(),
                    sqlMonitorMessage.getExceptionMsg(), sqlMonitorMessage.getStackTrace());
        }
        log.warn(sqlMsg);
        sendNotice(sqlMonitorMessage);
    }

    /**
     * 发送通知
     *
     * @param sqlMonitorMessage SQL监控消息
     */
    public abstract void sendNotice(SqlMonitorMessage sqlMonitorMessage);
}
