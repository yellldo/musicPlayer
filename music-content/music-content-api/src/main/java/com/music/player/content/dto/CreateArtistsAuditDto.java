package com.music.player.content.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : CreateArtistsAuditDto<br>
 * Description : CreateArtistsAuditDto<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CreateArtistsAuditDto implements Serializable {

    private Long userId;

    private String auditType;

    private String submittedData;
}
