package com.music.player.system.convert;

import com.music.player.system.dto.SysMenuCreateDto;
import com.music.player.system.dto.SysMenuUpdateDto;
import com.music.player.system.entity.SysMenu;
import com.music.player.system.vo.SysMenuVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClassName : SysMenuConvert<br>
 * Description : SysMenuConvert<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANT = Mappers.getMapper(SysMenuConvert.class);


    SysMenu create(SysMenuCreateDto sysMenuCreateDto);

    List<SysMenuVo> convertList(List<SysMenu> list);

    SysMenuVo copy(SysMenu sysMenu);

    SysMenu update(SysMenuUpdateDto sysMenuUpdateDto);
}
