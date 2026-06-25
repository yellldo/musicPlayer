package com.music.player.user.service.impl;

import com.music.player.user.entity.Member;
import com.music.player.user.mapper.MemberMapper;
import com.music.player.user.service.MemberService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : MemberServiceImpl<br>
 * Description : MemberServiceImpl<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, Member> implements MemberService {
}
