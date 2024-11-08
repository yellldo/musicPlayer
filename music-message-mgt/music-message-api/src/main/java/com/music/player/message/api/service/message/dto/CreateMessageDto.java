package com.music.player.message.api.service.message.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : CreateMessageDto<br>
 * Description : CreateMessageDto<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CreateMessageDto {

    /**
     * 接收人id
     */
    private Long receiverId;

    /**
     * 发送人id
     */
    private Long senderId;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String context;

}
