package com.music.player.user.service.impl;

import com.music.player.user.entity.MemberLevel;
import com.music.player.user.mapper.MemberLevelMapper;
import com.music.player.user.service.MemberLevelService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberLevelServiceImpl extends BaseServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {
}
