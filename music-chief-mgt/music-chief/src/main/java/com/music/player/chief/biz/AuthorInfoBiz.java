package com.music.player.chief.biz;

import com.music.player.chief.api.service.author.dto.AuthenticatedDto;
import com.music.player.chief.convert.AuthorApplyInfoConvert;
import com.music.player.chief.entity.AuthorApplyInfo;
import com.music.player.chief.service.AuthorApplyInfoService;
import com.music.player.chief.service.AuthorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorInfoBiz {

    @Autowired
    private AuthorInfoService authorInfoService;
    @Autowired
    private AuthorApplyInfoService authorApplyInfoService;


    /**
     * 插入一条申请数据
     *
     * @param authenticatedDto
     */
    public void authenticated(AuthenticatedDto authenticatedDto) {
        AuthorApplyInfo authorApplyInfo = AuthorApplyInfoConvert.INSTANT.authenticated(authenticatedDto);
        authorApplyInfoService.save(authorApplyInfo);
    }

}
