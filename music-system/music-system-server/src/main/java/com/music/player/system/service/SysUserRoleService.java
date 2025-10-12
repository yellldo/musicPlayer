package com.music.player.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.entity.SysUserRole;

/**
 * ClassName : SysUserRoleService<br>
 * Description : SysUserRoleService<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@DS("system")
public interface SysUserRoleService extends IBaseService<SysUserRole> {
}
