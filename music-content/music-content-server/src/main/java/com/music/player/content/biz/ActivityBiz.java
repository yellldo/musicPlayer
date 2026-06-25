package com.music.player.content.biz;

import com.music.player.content.constant.ActivityConstants;
import com.music.player.content.convert.ActivityConvert;
import com.music.player.content.dto.ActivityCreateDto;
import com.music.player.content.dto.ActivityPageDto;
import com.music.player.content.dto.ActivityUpdateDto;
import com.music.player.content.entity.Activity;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.service.ActivityService;
import com.music.player.content.vo.ActivityVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName : ActivityBiz<br>
 * Description : 活动运营业务层<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Component
public class ActivityBiz {

    @Autowired
    private ActivityService activityService;

    public PageResult<ActivityVo> page(ActivityPageDto dto) {
        PageResult<Activity> pageResult = activityService.selectPage(dto, new LambdaQueryWrapperX<Activity>()
                .likeIfPresent(Activity::getName, dto.getName())
                .eqIfPresent(Activity::getType, dto.getType())
                .eqIfPresent(Activity::getStatus, dto.getStatus())
                .eq(Activity::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return ActivityConvert.INSTANT.convertPage(pageResult);
    }

    public ActivityVo detail(Long id) {
        Activity activity = activityService.getById(id);
        if (activity == null) {
            throw new BusinessException(ErrorCodeConstants.ACTIVITY_NOT_FOUND);
        }
        return ActivityConvert.INSTANT.toVo(activity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(ActivityCreateDto dto) {
        Activity activity = ActivityConvert.INSTANT.create(dto);
        if (activity.getStatus() == null) {
            activity.setStatus(ActivityConstants.STATUS_ONGOING);
        }
        activityService.save(activity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(ActivityUpdateDto dto) {
        Activity origin = activityService.getById(dto.getId());
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.ACTIVITY_NOT_FOUND);
        }
        Activity activity = ActivityConvert.INSTANT.update(dto);
        activityService.updateById(activity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Activity origin = activityService.getById(id);
        if (origin == null) {
            throw new BusinessException(ErrorCodeConstants.ACTIVITY_NOT_FOUND);
        }
        activityService.removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void toggleStatus(Long id) {
        Activity activity = activityService.getById(id);
        if (activity == null) {
            throw new BusinessException(ErrorCodeConstants.ACTIVITY_NOT_FOUND);
        }
        String newStatus = ActivityConstants.STATUS_ONGOING.equals(activity.getStatus())
                ? ActivityConstants.STATUS_ENDED
                : ActivityConstants.STATUS_ONGOING;
        Activity update = new Activity();
        update.setId(id);
        update.setStatus(newStatus);
        activityService.updateById(update);
    }
}
