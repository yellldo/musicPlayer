package com.music.player.user.convert;

import com.music.player.user.dto.MemberTagCreateDto;
import com.music.player.user.dto.MemberTagUpdateDto;
import com.music.player.user.entity.MemberTag;
import com.music.player.user.vo.MemberTagVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberTagConvert {

    MemberTagConvert INSTANT = Mappers.getMapper(MemberTagConvert.class);

    MemberTag create(MemberTagCreateDto dto);

    MemberTag update(MemberTagUpdateDto dto);

    PageResult<MemberTagVo> convertPage(PageResult<MemberTag> pageResult);

    MemberTagVo toVo(MemberTag entity);
}
