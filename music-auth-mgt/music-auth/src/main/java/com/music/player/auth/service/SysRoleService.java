package com.music.player.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.auth.dto.QueryRoleListDto;
import com.music.player.auth.entity.SysRole;
import com.music.player.auth.vo.SysRoleVo;
import com.music.player.framework.common.base.R;

import java.util.List;

/**
 * ClassName : SysRoleService<br>
 * Description : SysRoleService<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
public interface SysRoleService extends IService<SysRole> {


    IPage<SysRoleVo> queryRoleList(QueryRoleListDto queryRoleListDto);
}
