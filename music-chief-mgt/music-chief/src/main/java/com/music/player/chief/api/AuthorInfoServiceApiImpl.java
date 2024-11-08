package com.music.player.chief.api;

import com.music.player.chief.api.enums.ErrorCodeConstants;
import com.music.player.chief.api.service.author.AuthorInfoServiceApi;
import com.music.player.chief.api.service.author.dto.AuditAuthorDto;
import com.music.player.chief.api.service.author.dto.AuthenticatedDto;
import com.music.player.chief.api.service.author.dto.FetchAuthorInfoDto;
import com.music.player.chief.api.service.author.vo.AuditAuthorVo;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.chief.biz.AuthorInfoBiz;
import com.music.player.chief.constants.AuthorConstants;
import com.music.player.chief.constants.AuthorRedisConstant;
import com.music.player.chief.convert.AuthorApplyInfoConvert;
import com.music.player.chief.convert.AuthorInfoConvert;
import com.music.player.chief.entity.AuthorApplyInfo;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.service.AuthorApplyInfoService;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthorInfoServiceApiImpl implements AuthorInfoServiceApi {

    @Autowired
    private AuthorInfoBiz authorInfoBiz;
    @Autowired
    private AuthorApplyInfoService authorApplyInfoService;
    @Autowired
    private AuthorInfoService authorInfoService;
    @Autowired
    private CacheService cacheService;

    @Override
    public void authenticated(AuthenticatedDto authenticatedDto) {
        authorInfoBiz.authenticated(authenticatedDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<AuditAuthorVo> auditAuthor(AuditAuthorDto auditAuthorDto) {
        AuthorApplyInfo authorApplyInfo = AuthorApplyInfoConvert.INSTANT.auditAuthor(auditAuthorDto);
        authorApplyInfoService.updateById(authorApplyInfo);
        AuditAuthorVo auditAuthorVo = new AuditAuthorVo();
        if (AuthorConstants.AUTHOR_AUDIT_STATUS_PASS.equals(auditAuthorDto.getAuditStatus())) {
            AuthorInfo authorInfo = new AuthorInfo();
            authorApplyInfo = authorApplyInfoService.getById(auditAuthorDto.getAuthorApplyId());
            if (auditAuthorDto.getAuthorId() != null) {
                authorInfo = AuthorInfoConvert.INSTANT.authorApplyInfo(authorApplyInfo);
                authorInfoService.updateById(authorInfo);
            } else {
                authorInfo = AuthorInfoConvert.INSTANT.authorApplyInfo(authorApplyInfo);
                authorInfoService.save(authorInfo);
            }
            auditAuthorVo.setAuthorId(authorInfo.getAuthorId());
            cacheService.set(AuthorRedisConstant.AUTHOR_KEY + authorInfo.getAuthorId(), AuthorInfoConvert.INSTANT.authorInfoVo(authorInfo));
        }
        auditAuthorVo.setUserId(authorApplyInfo.getUserId());
        return R.ok(auditAuthorVo);
    }

    @Override
    public R<FetchAuthorInfoVo> fetchAuthorInfo(FetchAuthorInfoDto fetchAuthorInfoDto) {
        AuthorInfo authorInfo = authorInfoService.getById(fetchAuthorInfoDto.getId());
        if (Objects.isNull(authorInfo)) {
            throw new BizException(ErrorCodeConstants.AUTHOR_NOT_EXISTS);
        }
        FetchAuthorInfoVo fetchAuthorInfoVo = AuthorInfoConvert.INSTANT.fetchAuthorInfo(authorInfo);
        return R.ok(fetchAuthorInfoVo);
    }
}
