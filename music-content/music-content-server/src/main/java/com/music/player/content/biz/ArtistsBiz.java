package com.music.player.content.biz;

import com.music.player.content.convert.ArtistsConvert;
import com.music.player.content.dto.ArtistsPageDto;
import com.music.player.content.entity.Artists;
import com.music.player.content.service.ArtistsService;
import com.music.player.content.vo.ArtistsVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName : ArtistsBiz<br>
 * Description : ArtistsBiz<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Component
public class ArtistsBiz {


    @Autowired
    private ArtistsService artistsService;

    public PageResult<ArtistsVo> page(ArtistsPageDto artistsPageDto) {
        PageResult<Artists> artistsPageResult = artistsService.selectPage(artistsPageDto, new LambdaQueryWrapperX<Artists>()
                .eq(Artists::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return ArtistsConvert.INSTANT.page(artistsPageResult);
    }


}
