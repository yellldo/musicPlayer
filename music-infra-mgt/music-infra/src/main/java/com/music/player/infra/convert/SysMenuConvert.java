package com.music.player.infra.convert;

import com.music.player.infra.entity.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysMenuConvert<br>
 * Description : SysMenuConvert<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Mapper
public interface SysMenuConvert {

    SysMenuConvert INSTANT = Mappers.getMapper(SysMenuConvert.class);


    @Mappings({
            @Mapping(source = "menuName", target = "menuName")
    })
    SysMenu saveMenu(SaveMenuDto saveMenuDto);
}
