package com.music.player.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : UserMessage<br>
 * Description : UserMessage<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@Setter
@Getter
@ToString
@TableName("user_message")
public class UserMessage extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("message_title")
    private String messageTitle;

    @TableField("message_content")
    private String messageContent;

    @TableField("message_type")
    private String messageType;

    @TableField("is_read")
    private String isRead;

    @TableField("send_id")
    private Long sendId;

    @TableField("receive_id")
    private String receiveId;

}
