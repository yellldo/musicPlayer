package com.music.player.content.dto;

import com.music.player.framework.common.base.QueryRequest;
import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : ArtistsAuditPageDto<br>
 * Description : ArtistsAuditPageDto<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Setter
@Getter
@ToString
public class ArtistsAuditPageDto extends QueryRequestParam {

    private String auditStatus;

    private String auditType;
}
