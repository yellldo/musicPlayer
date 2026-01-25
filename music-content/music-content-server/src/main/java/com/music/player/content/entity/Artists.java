package com.music.player.content.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : Artists<br>
 * Description : Artists<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Setter
@Getter
@ToString
@TableName("artists")
public class Artists extends BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long artId;

    @TableField("user_id")
    private Long userId;

    @JsonProperty("art_name")
    @TableField("art_name")
    private String artName;

    @JsonProperty("alias")
    @TableField("alias")
    private String alias;

    @TableField("art_status")
    private String artStatus;

    @JsonProperty("avatar_url")
    @TableField("avatar_url")
    private String avatarUrl;

    @JsonProperty("cover_url")
    @TableField("cover_url")
    private String coverUrl;

    @TableField("description")
    private String description;

    @TableField("music_size")
    private Integer musicSize;

    @TableField("album_size")
    private Integer albumSize;
}
