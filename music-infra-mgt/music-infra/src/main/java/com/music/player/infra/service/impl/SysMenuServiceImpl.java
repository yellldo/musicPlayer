package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.entity.SysMenu;
import com.music.player.infra.mapper.SysMenuMapper;
import com.music.player.infra.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysMenuServiceImpl<br>
 * Description : SysMenuServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public IPage<QuerySysMenuVo> querySysMenu(QuerySysMenuDto querySysMenuDto) {
        if (StringUtils.isNotBlank(querySysMenuDto.getMenuName())) {
            querySysMenuDto.setMenuName("%" + querySysMenuDto.getMenuName() + "%");
        }
        Page<QuerySysMenuVo> page = new Page<>(querySysMenuDto.getPageNum(), querySysMenuDto.getPageSize());
        return baseMapper.querySysMenu(page, querySysMenuDto);
    }
}
