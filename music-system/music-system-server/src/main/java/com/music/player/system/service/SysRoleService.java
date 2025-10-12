package com.music.player.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.entity.SysRole;

/**
 * ClassName : SysRoleService<br>
 * Description : SysRoleService<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@DS("system")
public interface SysRoleService extends IBaseService<SysRole> {
}
