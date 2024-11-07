package com.music.player.adm.convert;

import com.music.player.adm.dto.SysUserRegisterDto;
import com.music.player.adm.entity.SysUser;
import com.music.player.adm.vo.SysUserInfoVo;
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


    SysUser register(SysUserRegisterDto sysUserRegisterDto);

    SysUserInfoVo login(SysUser sysUser);

}
