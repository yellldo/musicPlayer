package com.music.player.content.service.impl;

import com.music.player.content.entity.Genre;
import com.music.player.content.mapper.GenreMapper;
import com.music.player.content.service.GenreService;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName : GenreServiceImpl<br>
 * Description : GenreServiceImpl<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Service
public class GenreServiceImpl extends BaseServiceImpl<GenreMapper, Genre> implements GenreService {
}
