package com.music.player.infra.convert;

import com.music.player.infra.api.dto.DeleteSysRoleDto;
import com.music.player.infra.api.dto.SaveSysRoleDto;
import com.music.player.infra.api.dto.UpdateSysRoleDto;
import com.music.player.infra.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysRoleConvert<br>
 * Description : SysRoleConvert<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANT = Mappers.getMapper(SysRoleConvert.class);


    SysRole saveRole(SaveSysRoleDto saveSysRoleDto);

    SysRole updateSysRole(UpdateSysRoleDto updateSysRoleDto);

    SysRole deleteSysRole(DeleteSysRoleDto deleteSysRoleDto);


}
