package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.UserInfo;
import com.music.player.auth.mapper.UserInfoMapper;
import com.music.player.auth.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserInfoServiceImpl<br>
 * Description : UserInfoServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

}
