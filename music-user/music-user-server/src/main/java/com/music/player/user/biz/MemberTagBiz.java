package com.music.player.user.biz;

import com.music.player.user.constant.MemberTagConstants;
import com.music.player.user.convert.MemberTagConvert;
import com.music.player.user.dto.MemberTagCreateDto;
import com.music.player.user.dto.MemberTagPageDto;
import com.music.player.user.dto.MemberTagUpdateDto;
import com.music.player.user.entity.MemberTag;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.service.MemberTagService;
import com.music.player.user.vo.MemberTagVo;
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
public class MemberTagBiz {

    @Autowired
    private MemberTagService memberTagService;

    public PageResult<MemberTagVo> page(MemberTagPageDto dto) {
        PageResult<MemberTag> pageResult = memberTagService.selectPage(dto, new LambdaQueryWrapperX<MemberTag>()
                .likeIfPresent(MemberTag::getName, dto.getName())
                .eqIfPresent(MemberTag::getStatus, dto.getStatus())
                .eq(MemberTag::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberTag::getSort));
        return MemberTagConvert.INSTANT.convertPage(pageResult);
    }

    public MemberTagVo detail(Long id) {
        MemberTag entity = memberTagService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_TAG_NOT_FOUND);
        }
        return MemberTagConvert.INSTANT.toVo(entity);
    }

    public List<MemberTagVo> list() {
        List<MemberTag> list = memberTagService.selectList(new LambdaQueryWrapperX<MemberTag>()
                .eq(MemberTag::getStatus, MemberTagConstants.STATUS_ENABLED)
                .eq(MemberTag::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberTag::getSort));
        return list.stream().map(MemberTagConvert.INSTANT::toVo).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(MemberTagCreateDto dto) {
        MemberTag entity = MemberTagConvert.INSTANT.create(dto);
        if (entity.getStatus() == null) {
            entity.setStatus(MemberTagConstants.STATUS_ENABLED);
        }
        memberTagService.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MemberTagUpdateDto dto) {
        MemberTag origin = memberTagService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_TAG_NOT_FOUND);
        }
        MemberTag entity = MemberTagConvert.INSTANT.update(dto);
        memberTagService.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        MemberTag origin = memberTagService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_TAG_NOT_FOUND);
        }
        memberTagService.removeById(id);
    }
}
