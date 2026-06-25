package com.music.player.content.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.music.player.framework.mybatis.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : PlaylistAudit<br>
 * Description : 歌单审核<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@TableName("playlist_audit")
public class PlaylistAudit extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("playlist_name")
    private String playlistName;

    @TableField("cover_url")
    private String coverUrl;

    @TableField("description")
    private String description;

    @TableField("tags")
    private String tags;

    @TableField("song_list")
    private String songList;

    @TableField("submit_user_id")
    private Long submitUserId;

    @TableField("submit_user_name")
    private String submitUserName;

    @TableField("audit_status")
    private String auditStatus;

    @TableField("audit_opinion")
    private String auditOpinion;

    @TableField("audit_user_id")
    private Long auditUserId;

    @TableField("audit_user_name")
    private String auditUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("audit_time")
    private LocalDateTime auditTime;
}
