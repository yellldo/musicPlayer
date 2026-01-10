package com.music.player.content.service.impl;

import com.music.player.content.entity.Artists;
import com.music.player.content.mapper.ArtistsMapper;
import com.music.player.content.service.ArtistsService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : ArtistsServiceImpl<br>
 * Description : ArtistsServiceImpl<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Service
public class ArtistsServiceImpl extends BaseServiceImpl<ArtistsMapper, Artists> implements ArtistsService {
}
