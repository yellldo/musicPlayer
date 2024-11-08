package com.music.player.chief.service;

import com.music.player.chief.api.service.author.vo.AuthorInfoVo;

public interface AuthorCacheService {


    void cacheAuthor(Long authorId, AuthorInfoVo authorInfoVo);


    AuthorInfoVo getAuthor(Long authorId);

}
