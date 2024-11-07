package com.music.player.adm.convert;

import com.music.player.adm.dto.SaveSysMenuDto;
import com.music.player.adm.entity.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysMenuConvert<br>
 * Description : SysMenuConvert<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANT = Mappers.getMapper(SysMenuConvert.class);


    SysMenu saveSysMenu(SaveSysMenuDto saveSysMenuDto);

}
