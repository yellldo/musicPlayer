package com.music.player.content.service.impl;

import com.music.player.content.entity.Activity;
import com.music.player.content.mapper.ActivityMapper;
import com.music.player.content.service.ActivityService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : ActivityServiceImpl<br>
 * Description : ActivityServiceImpl<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Service
public class ActivityServiceImpl extends BaseServiceImpl<ActivityMapper, Activity> implements ActivityService {
}
