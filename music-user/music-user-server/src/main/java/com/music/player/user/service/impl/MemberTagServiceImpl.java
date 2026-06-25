package com.music.player.user.service.impl;

import com.music.player.user.entity.MemberTag;
import com.music.player.user.mapper.MemberTagMapper;
import com.music.player.user.service.MemberTagService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberTagServiceImpl extends BaseServiceImpl<MemberTagMapper, MemberTag> implements MemberTagService {
}
