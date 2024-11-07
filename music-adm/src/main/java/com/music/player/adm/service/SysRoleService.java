package com.music.player.adm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.adm.dto.QueryRoleListDto;
import com.music.player.adm.entity.SysRole;
import com.music.player.adm.vo.SysRoleVo;

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
