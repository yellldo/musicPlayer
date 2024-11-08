package com.music.player.adm.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.music.player.adm.convert.SysMenuConvert;
import com.music.player.adm.dto.SaveSysMenuDto;
import com.music.player.adm.entity.SysMenu;
import com.music.player.adm.enums.ErrorCodeConstants;
import com.music.player.adm.service.SysMenuService;
import com.music.player.framework.common.constant.CommonConstants;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysMenuBiz<br>
 * Description : SysMenuBiz<br>
 *
 * @author : sj
 * @date : 2024/9/12
 */
@Service
public class SysMenuBiz {

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * Add a menu
     */
    public void saveSysMenu(SaveSysMenuDto saveSysMenuDto) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysMenu::getMenuName, saveSysMenuDto.getMenuName());
        queryWrapper.eq(SysMenu::getIsDelete, CommonConstants.STATUS_NOT_DEL);
        queryWrapper.eq(SysMenu::getLevel, saveSysMenuDto.getLevel());
        long count = sysMenuService.count(queryWrapper);
        if (count > 0) {
            throw new BizException(ErrorCodeConstants.SYS_ROLE_EXISTS);
        }
        sysMenuService.save(SysMenuConvert.INSTANT.saveSysMenu(saveSysMenuDto));
    }
}
