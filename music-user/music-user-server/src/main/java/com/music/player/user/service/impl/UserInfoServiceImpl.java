package com.music.player.user.service.impl;

import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.user.entity.UserInfo;
import com.music.player.user.mapper.UserInfoMapper;
import com.music.player.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserInfoServiceImpl<br>
 * Description : UserInfoServiceImpl<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
