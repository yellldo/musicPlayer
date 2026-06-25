package com.music.player.content.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : PlaylistAuditAuditDto<br>
 * Description : 歌单审核操作（通过/驳回）<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
public class PlaylistAuditAuditDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String auditOpinion;
}
