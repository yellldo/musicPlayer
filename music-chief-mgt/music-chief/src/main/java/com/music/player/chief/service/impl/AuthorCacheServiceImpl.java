package com.music.player.chief.service.impl;

import com.music.player.chief.api.service.author.vo.AuthorInfoVo;
import com.music.player.chief.constants.AuthorRedisConstant;
import com.music.player.chief.service.AuthorCacheService;
import com.music.player.framework.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class AuthorCacheServiceImpl implements AuthorCacheService {

    @Autowired
    private CacheService cacheService;

    @Override
    public void cacheAuthor(Long authorId, AuthorInfoVo authorInfoVo) {
        String key = AuthorRedisConstant.AUTHOR_KEY + authorId;
        cacheService.set(key, authorInfoVo, Duration.ofDays(10));
    }

    @Override
    public AuthorInfoVo getAuthor(Long authorId) {
        String key = AuthorRedisConstant.AUTHOR_KEY + authorId;
        return cacheService.get(key);
    }
}
