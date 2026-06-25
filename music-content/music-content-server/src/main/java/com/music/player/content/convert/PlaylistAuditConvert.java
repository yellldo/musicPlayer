package com.music.player.content.convert;

import com.music.player.content.dto.PlaylistAuditAuditDto;
import com.music.player.content.entity.PlaylistAudit;
import com.music.player.content.vo.PlaylistAuditVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : PlaylistAuditConvert<br>
 * Description : 歌单审核对象转换<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Mapper
public interface PlaylistAuditConvert {

    PlaylistAuditConvert INSTANT = Mappers.getMapper(PlaylistAuditConvert.class);

    PageResult<PlaylistAuditVo> convertPage(PageResult<PlaylistAudit> pageResult);

    PlaylistAuditVo toVo(PlaylistAudit entity);

    PlaylistAudit audit(PlaylistAuditAuditDto dto);
}
