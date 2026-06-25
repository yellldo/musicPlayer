package com.music.player.content.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : PlaylistAuditPageDto<br>
 * Description : 歌单审核分页查询<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
public class PlaylistAuditPageDto extends QueryRequestParam {

    private String playlistName;

    private String auditStatus;
}
