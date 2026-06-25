package com.music.player.content.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : PlaylistAuditVo<br>
 * Description : 歌单审核视图对象<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
public class PlaylistAuditVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String playlistName;

    private String coverUrl;

    private String description;

    private String tags;

    private String songList;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long submitUserId;

    private String submitUserName;

    private String auditStatus;

    private String auditOpinion;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long auditUserId;

    private String auditUserName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime auditTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
