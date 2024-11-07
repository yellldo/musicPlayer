package com.music.player.chief.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.mapper.AuthorInfoMapper;
import com.music.player.chief.service.AuthorInfoService;
import org.springframework.stereotype.Service;

@Service
public class AuthorInfoServiceImpl extends ServiceImpl<AuthorInfoMapper, AuthorInfo> implements AuthorInfoService {
}
