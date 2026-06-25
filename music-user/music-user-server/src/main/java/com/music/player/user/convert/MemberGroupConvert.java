package com.music.player.user.convert;

import com.music.player.user.dto.MemberGroupCreateDto;
import com.music.player.user.dto.MemberGroupUpdateDto;
import com.music.player.user.entity.MemberGroup;
import com.music.player.user.vo.MemberGroupVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberGroupConvert {

    MemberGroupConvert INSTANT = Mappers.getMapper(MemberGroupConvert.class);

    MemberGroup create(MemberGroupCreateDto dto);

    MemberGroup update(MemberGroupUpdateDto dto);

    PageResult<MemberGroupVo> convertPage(PageResult<MemberGroup> pageResult);

    MemberGroupVo toVo(MemberGroup entity);
}
