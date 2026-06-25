package com.music.player.user.service.impl;

import com.music.player.user.entity.MemberGroup;
import com.music.player.user.mapper.MemberGroupMapper;
import com.music.player.user.service.MemberGroupService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberGroupServiceImpl extends BaseServiceImpl<MemberGroupMapper, MemberGroup> implements MemberGroupService {
}
