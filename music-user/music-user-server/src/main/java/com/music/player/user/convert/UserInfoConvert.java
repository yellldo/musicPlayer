package com.music.player.user.convert;

import com.music.player.framework.common.base.PageResult;
import com.music.player.user.dto.CreateUserInfoDto;
import com.music.player.user.dto.RegisterUserDto;
import com.music.player.user.dto.UpdateUserInfoDto;
import com.music.player.user.entity.UserInfo;
import com.music.player.user.vo.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : UserInfoConvert<br>
 * Description : UserInfoConvert<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Mapper
public interface UserInfoConvert {

    UserInfoConvert INSTANT = Mappers.getMapper(UserInfoConvert.class);


    UserInfo create(CreateUserInfoDto createUserInfoDto);

    PageResult<UserInfoVo> convertPage(PageResult<UserInfo> pageResult);

    UserInfo update(UpdateUserInfoDto updateUserInfoDto);

    CreateUserInfoDto doCreate(RegisterUserDto registerUserDto);
}
