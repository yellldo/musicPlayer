package com.music.player.content.service.impl;

import com.music.player.content.entity.Advertise;
import com.music.player.content.mapper.AdvertiseMapper;
import com.music.player.content.service.AdvertiseService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : AdvertiseServiceImpl<br>
 * Description : AdvertiseServiceImpl<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Service
public class AdvertiseServiceImpl extends BaseServiceImpl<AdvertiseMapper, Advertise> implements AdvertiseService {
}
