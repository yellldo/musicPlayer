package com.music.player.adm.biz;

import com.music.player.adm.dto.AdmAuditAuthorDto;
import com.music.player.auth.api.service.user.UserServiceApi;
import com.music.player.auth.api.service.user.dto.SaveUserAuthorInfoDto;
import com.music.player.chief.api.service.author.AuthorInfoServiceApi;
import com.music.player.chief.api.service.author.dto.AuditAuthorDto;
import com.music.player.chief.api.service.author.vo.AuditAuthorVo;
import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorBiz {

    @Autowired
    private AuthorInfoServiceApi authorInfoServiceApi;
    @Autowired
    private UserServiceApi userServiceApi;

    public void auditAuthor(AdmAuditAuthorDto admAuditAuthorDto) {
        AuditAuthorDto auditAuthorDto = new AuditAuthorDto();
        BeanUtils.copyProperties(admAuditAuthorDto, auditAuthorDto);
        R<AuditAuthorVo> result = authorInfoServiceApi.auditAuthor(auditAuthorDto);
        if (HttpCode.SUCCESS.getCode() == result.getCode()) {
            AuditAuthorVo auditAuthorVo = result.getData();
            SaveUserAuthorInfoDto saveUserAuthorInfoDto = new SaveUserAuthorInfoDto()
                    .setAuthorId(auditAuthorVo.getAuthorId())
                    .setUserId(auditAuthorVo.getUserId());
            userServiceApi.saveUserAuthorInfo(saveUserAuthorInfoDto);
        }

    }

}
