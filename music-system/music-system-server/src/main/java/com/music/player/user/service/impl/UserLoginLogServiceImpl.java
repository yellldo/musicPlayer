package com.music.player.user.service.impl;


import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.user.entity.UserLoginLog;
import com.music.player.user.mapper.UserLoginLogMapper;
import com.music.player.user.service.UserLoginLogService;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserLoginLogServiceImpl<br>
 * Description : UserLoginLogServiceImpl<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Service
public class UserLoginLogServiceImpl extends BaseServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService {
}
