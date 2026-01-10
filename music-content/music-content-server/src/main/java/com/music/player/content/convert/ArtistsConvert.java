package com.music.player.content.convert;

import com.music.player.content.entity.Artists;
import com.music.player.content.entity.ArtistsAudit;
import com.music.player.content.vo.ArtistsVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : ArtistsConvert<br>
 * Description : ArtistsConvert<br>
 *
 * @author : sj
 * @date : 12/28/25
 */
@Mapper
public interface ArtistsConvert {

    ArtistsConvert INSTANT = Mappers.getMapper(ArtistsConvert.class);

    Artists create(ArtistsAudit artistsAudit);

    PageResult<ArtistsVo> page(PageResult<Artists> pageResult);
}
