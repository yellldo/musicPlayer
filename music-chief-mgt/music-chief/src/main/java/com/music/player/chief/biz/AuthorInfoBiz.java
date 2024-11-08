package com.music.player.chief.biz;

import com.music.player.chief.api.service.author.dto.AuthenticatedDto;
import com.music.player.chief.constants.AuthorRedisConstant;
import com.music.player.chief.convert.AuthorApplyInfoConvert;
import com.music.player.chief.convert.AuthorInfoConvert;
import com.music.player.chief.dto.UpdateAuthorInfoDto;
import com.music.player.chief.entity.AuthorApplyInfo;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.service.AuthorApplyInfoService;
import com.music.player.chief.service.AuthorCacheService;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.chief.api.service.author.vo.AuthorInfoVo;
import com.music.player.framework.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class AuthorInfoBiz {

    @Autowired
    private AuthorInfoService authorInfoService;
    @Autowired
    private AuthorApplyInfoService authorApplyInfoService;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private AuthorCacheService authorCacheService;


    /**
     * Insert a request data
     */
    public void authenticated(AuthenticatedDto authenticatedDto) {
        AuthorApplyInfo authorApplyInfo = AuthorApplyInfoConvert.INSTANT.authenticated(authenticatedDto);
        authorApplyInfoService.save(authorApplyInfo);
    }

    /**
     * Update author info
     * Although the author information is updated, the request data is actually inserted
     */
    public void updateAuthorInfo(UpdateAuthorInfoDto updateAuthorInfoDto) {
        AuthorApplyInfo authorApplyInfo = AuthorApplyInfoConvert.INSTANT.updateAuthorInfo(updateAuthorInfoDto);
        authorApplyInfoService.save(authorApplyInfo);
    }

    /**
     * Query author information
     * Query the cache first, hit the cache and return it directly, otherwise query the DB
     */
    public AuthorInfoVo queryAuthorInfo(Long authorId) {
        String key = AuthorRedisConstant.AUTHOR_KEY + authorId;
        if (cacheService.exists(key)) {
            return authorCacheService.getAuthor(authorId);
        }
        AuthorInfo authorInfo = authorInfoService.getById(authorId);
        AuthorInfoVo authorInfoVo = AuthorInfoConvert.INSTANT.authorInfoVo(authorInfo);
        authorCacheService.cacheAuthor(authorId, authorInfoVo);
        return authorInfoVo;
    }

}
