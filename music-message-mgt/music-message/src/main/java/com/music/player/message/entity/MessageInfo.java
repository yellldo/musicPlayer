package com.music.player.message.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@TableName("message_info")
public class MessageInfo {

    @TableId("message_id")
    private Long messageId;

    @TableField("message_type")
    private String messageType;

    @TableField("message_tile")
    private String messageTitle;

    @TableField("message_content")
    private String messageContent;

    @TableField("message_status")
    private String messageStatus;

    @TableField("message_receiver")
    private String messageReceiver;

    @TableField("retry_count")
    private Integer retryCount;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;
}
