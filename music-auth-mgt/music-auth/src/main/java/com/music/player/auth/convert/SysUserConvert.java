package com.music.player.auth.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysUserConvert<br>
 * Description : SysUserConvert<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANT = Mappers.getMapper(SysUserConvert.class);

}
