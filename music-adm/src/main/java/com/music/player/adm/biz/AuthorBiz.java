package com.music.player.adm.biz;

import com.music.player.adm.dto.AdmAuditAuthorDto;
import com.music.player.auth.api.service.user.UserServiceApi;
import com.music.player.auth.api.service.user.dto.SaveUserAuthorInfoDto;
import com.music.player.chief.api.service.author.AuthorInfoServiceApi;
import com.music.player.chief.api.service.author.dto.AuditAuthorDto;
import com.music.player.chief.api.service.author.dto.FetchAuthorInfoDto;
import com.music.player.chief.api.service.author.vo.AuditAuthorVo;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorBiz {

    @Autowired
    private AuthorInfoServiceApi authorInfoServiceApi;
    @Autowired
    private UserServiceApi userServiceApi;

    /**
     * The author audit
     * Obtain user information based on user type
     * TODO distributed transaction are required here
     */
    @Transactional(rollbackFor = Exception.class)
    public void auditAuthor(AdmAuditAuthorDto admAuditAuthorDto) {
        AuditAuthorDto auditAuthorDto = new AuditAuthorDto()
                .setAuditRemark(admAuditAuthorDto.getAuditRemark())
                .setAuthorApplyId(admAuditAuthorDto.getAuthorApplyId())
                .setAuditStatus(admAuditAuthorDto.getAuditStatus());
        R<AuditAuthorVo> result = authorInfoServiceApi.auditAuthor(auditAuthorDto);
        if (HttpCode.SUCCESS.getCode() == result.getCode()) {
            AuditAuthorVo auditAuthorVo = result.getData();
            // determine whether the author exists
            FetchAuthorInfoDto fetchAuthorInfoDto = new FetchAuthorInfoDto()
                    .setId(auditAuthorVo.getAuthorId());
            R<FetchAuthorInfoVo> fetchAuthorInfoVoR = authorInfoServiceApi.fetchAuthorInfo(fetchAuthorInfoDto);

            if (HttpCode.SUCCESS.getCode() == fetchAuthorInfoVoR.getCode()) {

            } else {
                SaveUserAuthorInfoDto saveUserAuthorInfoDto = new SaveUserAuthorInfoDto()
                        .setAuthorId(auditAuthorVo.getAuthorId())
                        .setUserId(auditAuthorVo.getUserId());
                userServiceApi.saveUserAuthorInfo(saveUserAuthorInfoDto);
            }
        }
    }

}
