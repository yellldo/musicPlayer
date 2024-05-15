package com.music.player.framework.mybatis.send;

/**
 * ClassName : SendNoticeService<br>
 * Description : 推送消息service<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public interface SendNoticeService {

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    void send(SqlMonitorMessage msg);
}
