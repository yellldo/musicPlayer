package com.music.player.content.convert;

import com.music.player.content.dto.ArtistsAuditAuditDto;
import com.music.player.content.dto.CreateArtistsAuditDto;
import com.music.player.content.entity.ArtistsAudit;
import com.music.player.content.vo.ArtistsAuditVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : ArtistsAuditConvert<br>
 * Description : ArtistsAuditConvert<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Mapper
public interface ArtistsAuditConvert {

    ArtistsAuditConvert INSTANT = Mappers.getMapper(ArtistsAuditConvert.class);


    ArtistsAudit create(CreateArtistsAuditDto createArtistsAuditDto);

    PageResult<ArtistsAuditVo> convertPage(PageResult<ArtistsAudit> pageResult);

    ArtistsAudit audit(ArtistsAuditAuditDto artistsAuditAuditDto);


}
