package com.music.player.system.service.impl;

import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.system.entity.DictInfo;
import com.music.player.system.mapper.DictInfoMapper;
import com.music.player.system.service.DictInfoService;
import org.springframework.stereotype.Service;

/**
 * ClassName : DictInfoServiceImpl<br>
 * Description : DictInfoServiceImpl<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Service
public class DictInfoServiceImpl extends BaseServiceImpl<DictInfoMapper, DictInfo> implements DictInfoService {
}
