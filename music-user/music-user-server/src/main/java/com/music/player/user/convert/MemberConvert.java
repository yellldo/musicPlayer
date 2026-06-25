package com.music.player.user.convert;

import com.music.player.user.dto.MemberCreateDto;
import com.music.player.user.dto.MemberUpdateDto;
import com.music.player.user.entity.Member;
import com.music.player.user.vo.MemberVo;
import com.music.player.framework.common.base.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : MemberConvert<br>
 * Description : 会员对象转换<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Mapper
public interface MemberConvert {

    MemberConvert INSTANT = Mappers.getMapper(MemberConvert.class);

    Member create(MemberCreateDto dto);

    Member update(MemberUpdateDto dto);

    PageResult<MemberVo> convertPage(PageResult<Member> pageResult);

    MemberVo toVo(Member entity);
}
