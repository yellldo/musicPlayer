package com.music.player.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.entity.SysUser;

/**
 * ClassName : SysUserService<br>
 * Description : SysUserService<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@DS("system")
public interface SysUserService extends IBaseService<SysUser> {
}
