package com.music.player.auth.convert;

import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.api.service.user.vo.UserInfoVo;
import com.music.player.auth.dto.UserRegisterDto;
import com.music.player.auth.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : UserConvert<br>
 * Description : UserConvert<br>
 *
 * @author : sj
 * @date : 2024/3/23
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANT = Mappers.getMapper(UserConvert.class);


    UserInfo register(UserRegisterDto userRegisterDto);


    JwtUser jwtUser(UserInfo userInfo);


    UserInfoVo getUserInfo(UserInfo userInfo);

}
