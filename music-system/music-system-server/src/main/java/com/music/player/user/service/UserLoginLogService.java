package com.music.player.user.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.user.entity.UserLoginLog;

/**
 * ClassName : UserLoginLogService<br>
 * Description : UserLoginLogService<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@DS("user")
public interface UserLoginLogService extends IBaseService<UserLoginLog> {
}
