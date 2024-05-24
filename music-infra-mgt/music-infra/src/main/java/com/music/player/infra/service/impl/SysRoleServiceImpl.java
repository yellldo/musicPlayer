package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.api.dto.QuerySysRoleDto;
import com.music.player.infra.api.vo.QuerySysRoleVo;
import com.music.player.infra.entity.SysRole;
import com.music.player.infra.mapper.SysRoleMapper;
import com.music.player.infra.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * ClassName : SysRoleServiceImpl<br>
 * Description : SysRoleServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public IPage<QuerySysRoleVo> querySysRole(QuerySysRoleDto querySysRoleDto) {
        Page<QuerySysRoleVo> page = new Page<>(querySysRoleDto.getPageNum(), querySysRoleDto.getPageSize());
        return baseMapper.querySysRole(page, querySysRoleDto);
    }
}
