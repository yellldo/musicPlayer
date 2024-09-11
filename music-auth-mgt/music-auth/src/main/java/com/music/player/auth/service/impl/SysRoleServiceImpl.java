package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.dto.QueryRoleListDto;
import com.music.player.auth.entity.SysRole;
import com.music.player.auth.mapper.SysRoleMapper;
import com.music.player.auth.service.SysRoleService;
import com.music.player.auth.vo.SysRoleVo;
import com.music.player.framework.common.base.R;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : SysRoleServiceImpl<br>
 * Description : SysRoleServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {


    @Override
    public IPage<SysRoleVo> queryRoleList(QueryRoleListDto queryRoleListDto) {
        Page<SysRoleVo> page = new Page<>(queryRoleListDto.getPageNum(), queryRoleListDto.getPageSize());
        return baseMapper.queryRoleList(page, queryRoleListDto);
    }
}
