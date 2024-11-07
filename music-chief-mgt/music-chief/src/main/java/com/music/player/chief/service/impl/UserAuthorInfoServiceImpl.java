package com.music.player.chief.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.chief.entity.UserAuthorInfo;
import com.music.player.chief.mapper.UserAuthorInfoMapper;
import com.music.player.chief.service.UserAuthorInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorInfoServiceImpl extends ServiceImpl<UserAuthorInfoMapper, UserAuthorInfo> implements UserAuthorInfoService {
}
