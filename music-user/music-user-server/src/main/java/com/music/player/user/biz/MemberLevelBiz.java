package com.music.player.user.biz;

import com.music.player.user.constant.MemberLevelConstants;
import com.music.player.user.convert.MemberLevelConvert;
import com.music.player.user.dto.MemberLevelCreateDto;
import com.music.player.user.dto.MemberLevelPageDto;
import com.music.player.user.dto.MemberLevelUpdateDto;
import com.music.player.user.entity.MemberLevel;
import com.music.player.user.enmus.ErrorCodeConstants;
import com.music.player.user.service.MemberLevelService;
import com.music.player.user.vo.MemberLevelVo;
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
public class MemberLevelBiz {

    @Autowired
    private MemberLevelService memberLevelService;

    public PageResult<MemberLevelVo> page(MemberLevelPageDto dto) {
        PageResult<MemberLevel> pageResult = memberLevelService.selectPage(dto, new LambdaQueryWrapperX<MemberLevel>()
                .likeIfPresent(MemberLevel::getName, dto.getName())
                .eqIfPresent(MemberLevel::getStatus, dto.getStatus())
                .eq(MemberLevel::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberLevel::getSort));
        return MemberLevelConvert.INSTANT.convertPage(pageResult);
    }

    public MemberLevelVo detail(Long id) {
        MemberLevel entity = memberLevelService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_LEVEL_NOT_FOUND);
        }
        return MemberLevelConvert.INSTANT.toVo(entity);
    }

    public List<MemberLevelVo> list() {
        List<MemberLevel> list = memberLevelService.selectList(new LambdaQueryWrapperX<MemberLevel>()
                .eq(MemberLevel::getStatus, MemberLevelConstants.STATUS_ENABLED)
                .eq(MemberLevel::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .orderByAsc(MemberLevel::getSort));
        return list.stream().map(MemberLevelConvert.INSTANT::toVo).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(MemberLevelCreateDto dto) {
        MemberLevel entity = MemberLevelConvert.INSTANT.create(dto);
        if (entity.getStatus() == null) {
            entity.setStatus(MemberLevelConstants.STATUS_ENABLED);
        }
        memberLevelService.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MemberLevelUpdateDto dto) {
        MemberLevel origin = memberLevelService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_LEVEL_NOT_FOUND);
        }
        MemberLevel entity = MemberLevelConvert.INSTANT.update(dto);
        memberLevelService.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        MemberLevel origin = memberLevelService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.MEMBER_LEVEL_NOT_FOUND);
        }
        memberLevelService.removeById(id);
    }
}
