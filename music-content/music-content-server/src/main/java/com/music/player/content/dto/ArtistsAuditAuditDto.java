package com.music.player.content.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : ArtistsAuditAuditDto<br>
 * Description : ArtistsAuditAuditDto<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Setter
@Getter
@ToString
public class ArtistsAuditAuditDto {

    private Long id;

    private String auditStatus;

    private String rejectReason;


}

