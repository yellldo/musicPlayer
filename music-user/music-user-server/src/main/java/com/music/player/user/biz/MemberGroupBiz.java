package com.music.player.user.biz;

import com.music.player.user.constant.MemberGroupConstants;
import com.music.player.user.convert.MemberGroupConvert;
import com.music.player.user.dto.MemberGroupCreateDto;
import com.music.player.user.dto.MemberGroupPageDto;
import com.music.player.user.dto.MemberGroupUpdateDto;
import com.music.player.user.entity.MemberGroup;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.service.MemberGroupService;
import com.music.player.user.vo.MemberGroupVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberGroupBiz {

    @Autowired
    private MemberGroupService memberGroupService;

    public PageResult<MemberGroupVo> page(MemberGroupPageDto dto) {
        PageResult<MemberGroup> pageResult = memberGroupService.selectPage(dto, new LambdaQueryWrapperX<MemberGroup>()
                .likeIfPresent(MemberGroup::getName, dto.getName())
                .eqIfPresent(MemberGroup::getStatus, dto.getStatus())
                .eq(MemberGroup::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberGroup::getSort));
        return MemberGroupConvert.INSTANT.convertPage(pageResult);
    }

    public MemberGroupVo detail(Long id) {
        MemberGroup entity = memberGroupService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_GROUP_NOT_FOUND);
        }
        return MemberGroupConvert.INSTANT.toVo(entity);
    }

    public List<MemberGroupVo> list() {
        List<MemberGroup> list = memberGroupService.selectList(new LambdaQueryWrapperX<MemberGroup>()
                .eq(MemberGroup::getStatus, MemberGroupConstants.STATUS_ENABLED)
                .eq(MemberGroup::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberGroup::getSort));
        return list.stream().map(MemberGroupConvert.INSTANT::toVo).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(MemberGroupCreateDto dto) {
        MemberGroup entity = MemberGroupConvert.INSTANT.create(dto);
        if (entity.getStatus() == null) {
            entity.setStatus(MemberGroupConstants.STATUS_ENABLED);
        }
        memberGroupService.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MemberGroupUpdateDto dto) {
        MemberGroup origin = memberGroupService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_GROUP_NOT_FOUND);
        }
        MemberGroup entity = MemberGroupConvert.INSTANT.update(dto);
        memberGroupService.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        MemberGroup origin = memberGroupService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_GROUP_NOT_FOUND);
        }
        memberGroupService.removeById(id);
    }
}
