package com.music.player.infra.biz;

import com.music.player.infra.convert.SysMenuConvert;
import com.music.player.infra.dto.SaveMenuDto;
import com.music.player.infra.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysMenuBiz<br>
 * Description : SysMenuBiz<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Service
public class SysMenuBiz {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 保存菜单
     *
     * @param saveMenuDto
     * @return
     */
    public Boolean saveMenu(SaveMenuDto saveMenuDto) {


        sysMenuService.save(SysMenuConvert.INSTANT.saveMenu(saveMenuDto));
        return Boolean.TRUE;
    }

}
