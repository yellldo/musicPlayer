package com.music.player.system.convert;

import com.music.player.framework.common.base.PageResult;
import com.music.player.system.dto.CreateSysUserDto;
import com.music.player.system.dto.SysUserResetPwdDto;
import com.music.player.system.dto.SysUserUpdateDto;
import com.music.player.system.entity.SysUser;
import com.music.player.system.vo.SysUserVo;
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

    PageResult<SysUserVo> convertPage(PageResult<SysUser> pageResult);

    SysUser update(SysUserUpdateDto sysUserUpdateDto);

    SysUser resetPwd(SysUserResetPwdDto sysUserResetPwdDto);

    SysUserVo copy(SysUser sysUser);
}

