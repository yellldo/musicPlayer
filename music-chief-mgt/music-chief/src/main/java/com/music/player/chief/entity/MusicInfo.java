package com.music.player.chief.entity;

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
@TableName("music_info")
public class MusicInfo {

    @TableId("music_id")
    private Long musicId;

    @TableField("music_name")
    private String musicName;

    @TableField("music_cover")
    private String musicCover;

    @TableField("author_id")
    private Long authorId;

    @TableField("collect_count")
    private Integer collectCount;

    @TableField("music_url")
    private String musicUrl;

    @TableField("duration")
    private Integer duration;

    @TableField("music_status")
    private String musicStatus;

    @TableField("is_delete")
    private String isDelete;

    @TableField("create_time")
    private Date createTime;
}
