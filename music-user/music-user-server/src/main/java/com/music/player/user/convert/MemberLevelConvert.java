package com.music.player.user.convert;

import com.music.player.user.dto.MemberLevelCreateDto;
import com.music.player.user.dto.MemberLevelUpdateDto;
import com.music.player.user.entity.MemberLevel;
import com.music.player.user.vo.MemberLevelVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberLevelConvert {

    MemberLevelConvert INSTANT = Mappers.getMapper(MemberLevelConvert.class);

    MemberLevel create(MemberLevelCreateDto dto);

    MemberLevel update(MemberLevelUpdateDto dto);

    PageResult<MemberLevelVo> convertPage(PageResult<MemberLevel> pageResult);

    MemberLevelVo toVo(MemberLevel entity);
}
