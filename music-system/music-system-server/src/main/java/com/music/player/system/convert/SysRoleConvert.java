package com.music.player.system.convert;

import com.music.player.framework.common.base.PageResult;
import com.music.player.system.dto.SysRoleCreateDto;
import com.music.player.system.dto.SysRoleUpdateDto;
import com.music.player.system.dto.SysRoleUpdateStatusDto;
import com.music.player.system.entity.SysRole;
import com.music.player.system.vo.SysRoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName : SysRoleConvert<br>
 * Description : SysRoleConvert<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANT = Mappers.getMapper(SysRoleConvert.class);


    SysRole create(SysRoleCreateDto sysRoleCreateDto);

    PageResult<SysRoleVo> convertPage(PageResult<SysRole> pageResult);

    List<SysRoleVo> convertList(List<SysRole> pageResult);

    SysRole updateStatus(SysRoleUpdateStatusDto sysRoleUpdateStatusDto);

    SysRole update(SysRoleUpdateDto sysRoleUpdateDto);
}
