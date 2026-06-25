package com.music.player.user.biz;

import com.music.player.user.constant.MemberConstants;
import com.music.player.user.convert.MemberConvert;
import com.music.player.user.dto.MemberCreateDto;
import com.music.player.user.dto.MemberPageDto;
import com.music.player.user.dto.MemberUpdateDto;
import com.music.player.user.entity.Member;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.service.MemberService;
import com.music.player.user.vo.MemberVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName : MemberBiz<br>
 * Description : 会员业务层<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@Component
public class MemberBiz {

    @Autowired
    private MemberService memberService;

    public PageResult<MemberVo> page(MemberPageDto dto) {
        PageResult<Member> pageResult = memberService.selectPage(dto, new LambdaQueryWrapperX<Member>()
                .likeIfPresent(Member::getUsername, dto.getUsername())
                .likeIfPresent(Member::getNickname, dto.getNickname())
                .eqIfPresent(Member::getLevelId, dto.getLevelId())
                .eqIfPresent(Member::getGroupId, dto.getGroupId())
                .eqIfPresent(Member::getStatus, dto.getStatus())
                .eq(Member::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return MemberConvert.INSTANT.convertPage(pageResult);
    }

    public MemberVo detail(Long id) {
        Member member = memberService.getById(id);
        if (member == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_NOT_FOUND);
        }
        return MemberConvert.INSTANT.toVo(member);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(MemberCreateDto dto) {
        Member member = MemberConvert.INSTANT.create(dto);
        if (member.getStatus() == null) {
            member.setStatus(MemberConstants.STATUS_NORMAL);
        }
        if (member.getPoints() == null) {
            member.setPoints(0);
        }
        memberService.save(member);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MemberUpdateDto dto) {
        Member origin = memberService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_NOT_FOUND);
        }
        Member member = MemberConvert.INSTANT.update(dto);
        memberService.updateById(member);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Member origin = memberService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_NOT_FOUND);
        }
        memberService.removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void toggleStatus(Long id) {
        Member member = memberService.getById(id);
        if (member == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_NOT_FOUND);
        }
        String newStatus = MemberConstants.STATUS_NORMAL.equals(member.getStatus())
                ? MemberConstants.STATUS_FROZEN
                : MemberConstants.STATUS_NORMAL;
        Member update = new Member();
        update.setId(id);
        update.setStatus(newStatus);
        memberService.updateById(update);
    }
}
