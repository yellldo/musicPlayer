package com.music.player.auth.convert;

import com.music.player.auth.dto.ModifyRoleDto;
import com.music.player.auth.dto.SaveRoleDto;
import com.music.player.auth.entity.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysRoleConvert<br>
 * Description : SysRoleConvert<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANT = Mappers.getMapper(SysRoleConvert.class);

    SysRole modifyRole(ModifyRoleDto modifyRoleDto);

    SysRole saveRole(SaveRoleDto saveRoleDto);
}
