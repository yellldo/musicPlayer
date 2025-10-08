package com.music.player.infra.service.impl;

import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.mapper.DictInfoMapper;
import com.music.player.infra.service.DictInfoService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
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
