package com.music.player.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@TableName("user_author_info")
public class UserAuthorInfo {

    @TableField("user_id")
    private Long userId;

    @TableField("author_id")
    private Long authorId;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;
}
