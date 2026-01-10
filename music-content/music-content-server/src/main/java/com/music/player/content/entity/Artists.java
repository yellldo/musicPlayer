package com.music.player.content.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableId
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("art_name")
    private String artName;

    @TableField("alias")
    private String alias;

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("cover_url")
    private String coverUrl;

    @TableField("description")
    private String description;

    @TableField("music_size")
    private Integer musicSize;

    @TableField("album_size")
    private Integer albumSize;
}
