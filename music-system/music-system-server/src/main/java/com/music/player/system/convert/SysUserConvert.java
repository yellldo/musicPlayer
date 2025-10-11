package com.music.player.system.convert;

import com.music.player.system.dto.CreateSysUserDto;
import com.music.player.system.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysUserConvert<br>
 * Description : SysUserConvert<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANT = Mappers.getMapper(SysUserConvert.class);

    SysUser create(CreateSysUserDto createSysUserDto);
}
