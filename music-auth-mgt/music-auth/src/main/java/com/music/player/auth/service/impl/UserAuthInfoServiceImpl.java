package com.music.player.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.auth.entity.UserAuthorInfo;
import com.music.player.auth.mapper.UserAuthorInfoMapper;
import com.music.player.auth.service.UserAuthorInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserAuthInfoServiceImpl extends ServiceImpl<UserAuthorInfoMapper, UserAuthorInfo> implements UserAuthorInfoService {
}
