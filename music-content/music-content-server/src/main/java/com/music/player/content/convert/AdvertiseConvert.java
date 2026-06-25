package com.music.player.content.convert;

import com.music.player.content.dto.AdvertiseCreateDto;
import com.music.player.content.dto.AdvertiseUpdateDto;
import com.music.player.content.entity.Advertise;
import com.music.player.content.vo.AdvertiseVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : AdvertiseConvert<br>
 * Description : 广告对象转换<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Mapper
public interface AdvertiseConvert {

    AdvertiseConvert INSTANT = Mappers.getMapper(AdvertiseConvert.class);

    Advertise create(AdvertiseCreateDto dto);

    Advertise update(AdvertiseUpdateDto dto);

    PageResult<AdvertiseVo> convertPage(PageResult<Advertise> pageResult);

    AdvertiseVo toVo(Advertise entity);
}
