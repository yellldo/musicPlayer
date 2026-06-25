package com.music.player.content.biz;

import com.music.player.content.constant.AdvertiseConstants;
import com.music.player.content.convert.AdvertiseConvert;
import com.music.player.content.dto.AdvertiseCreateDto;
import com.music.player.content.dto.AdvertisePageDto;
import com.music.player.content.dto.AdvertiseUpdateDto;
import com.music.player.content.entity.Advertise;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.service.AdvertiseService;
import com.music.player.content.vo.AdvertiseVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName : AdvertiseBiz<br>
 * Description : 广告投放业务层<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Component
public class AdvertiseBiz {

    @Autowired
    private AdvertiseService advertiseService;

    public PageResult<AdvertiseVo> page(AdvertisePageDto dto) {
        PageResult<Advertise> pageResult = advertiseService.selectPage(dto, new LambdaQueryWrapperX<Advertise>()
                .likeIfPresent(Advertise::getTitle, dto.getTitle())
                .eqIfPresent(Advertise::getType, dto.getType())
                .eqIfPresent(Advertise::getStatus, dto.getStatus())
                .eq(Advertise::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return AdvertiseConvert.INSTANT.convertPage(pageResult);
    }

    public AdvertiseVo detail(Long id) {
        Advertise advertise = advertiseService.getById(id);
        if (advertise == null) {
            throw new BusinessException(ErrorCodeConstants.ADVERTISE_NOT_FOUND);
        }
        return AdvertiseConvert.INSTANT.toVo(advertise);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(AdvertiseCreateDto dto) {
        Advertise advertise = AdvertiseConvert.INSTANT.create(dto);
        if (advertise.getStatus() == null) {
            advertise.setStatus(AdvertiseConstants.STATUS_OFFLINE);
        }
        advertiseService.save(advertise);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(AdvertiseUpdateDto dto) {
        Advertise origin = advertiseService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.ADVERTISE_NOT_FOUND);
        }
        Advertise advertise = AdvertiseConvert.INSTANT.update(dto);
        advertiseService.updateById(advertise);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Advertise origin = advertiseService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.ADVERTISE_NOT_FOUND);
        }
        advertiseService.removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void toggleStatus(Long id) {
        Advertise advertise = advertiseService.getById(id);
        if (advertise == null) {
            throw new BusinessException(ErrorCodeConstants.ADVERTISE_NOT_FOUND);
        }
        String newStatus = AdvertiseConstants.STATUS_ONLINE.equals(advertise.getStatus())
                ? AdvertiseConstants.STATUS_OFFLINE
                : AdvertiseConstants.STATUS_ONLINE;
        Advertise update = new Advertise();
        update.setId(id);
        update.setStatus(newStatus);
        advertiseService.updateById(update);
    }
}
