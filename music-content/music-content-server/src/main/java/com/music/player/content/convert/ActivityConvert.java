package com.music.player.content.convert;

import com.music.player.content.dto.ActivityCreateDto;
import com.music.player.content.dto.ActivityUpdateDto;
import com.music.player.content.entity.Activity;
import com.music.player.content.vo.ActivityVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : ActivityConvert<br>
 * Description : 活动对象转换<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Mapper
public interface ActivityConvert {

    ActivityConvert INSTANT = Mappers.getMapper(ActivityConvert.class);

    Activity create(ActivityCreateDto dto);

    Activity update(ActivityUpdateDto dto);

    PageResult<ActivityVo> convertPage(PageResult<Activity> pageResult);

    ActivityVo toVo(Activity entity);
}
