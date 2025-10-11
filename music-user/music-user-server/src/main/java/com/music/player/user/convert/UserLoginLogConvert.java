package com.music.player.user.convert;

import com.music.player.user.dto.CreateUserLoginLogDto;
import com.music.player.user.entity.UserLoginLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : UserLoginLogConvert<br>
 * Description : UserLoginLogConvert<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Mapper
public interface UserLoginLogConvert {

    UserLoginLogConvert INSTANT = Mappers.getMapper(UserLoginLogConvert.class);

    UserLoginLog record(CreateUserLoginLogDto createUserLoginLogDto);

}
