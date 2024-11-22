package com.music.player.adm.biz;

import com.music.player.adm.dto.AdmApprovalAuthorDto;
import com.music.player.auth.api.service.user.UserServiceApi;
import com.music.player.auth.api.service.user.dto.SaveUserAuthorInfoDto;
import com.music.player.chief.api.service.author.AuthorInfoServiceApi;
import com.music.player.chief.api.service.author.dto.ApprovalAuthorDto;
import com.music.player.chief.api.service.author.dto.FetchAuthorInfoDto;
import com.music.player.chief.api.service.author.vo.ApprovalAuthorVo;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorInfoBiz {

    @Autowired
    private AuthorInfoServiceApi authorInfoServiceApi;
    @Autowired
    private UserServiceApi userServiceApi;

    /**
     * The approval audit
     * Obtain user information based on user type
     * TODO distributed transaction are required here
     */
    @Transactional(rollbackFor = Exception.class)
    public void approvalAuthor(AdmApprovalAuthorDto admApprovalAuthorDto) {
        ApprovalAuthorDto approvalAuthorDto = new ApprovalAuthorDto()
                .setAuditRemark(admApprovalAuthorDto.getAuditRemark())
                .setAuthorApplyId(admApprovalAuthorDto.getAuthorApplyId())
                .setAuditStatus(admApprovalAuthorDto.getAuditStatus());
        R<ApprovalAuthorVo> result = authorInfoServiceApi.approvalAuthor(approvalAuthorDto);
        if (HttpCode.SUCCESS.getCode() == result.getCode()) {
            ApprovalAuthorVo approvalAuthorVo = result.getData();
            // determine whether the author exists
            FetchAuthorInfoDto fetchAuthorInfoDto = new FetchAuthorInfoDto()
                    .setId(approvalAuthorVo.getAuthorId());
            R<FetchAuthorInfoVo> fetchAuthorInfoVoR = authorInfoServiceApi.fetchAuthorInfo(fetchAuthorInfoDto);

            if (HttpCode.SUCCESS.getCode() == fetchAuthorInfoVoR.getCode()) {

            } else {
                SaveUserAuthorInfoDto saveUserAuthorInfoDto = new SaveUserAuthorInfoDto()
                        .setAuthorId(approvalAuthorVo.getAuthorId())
                        .setUserId(approvalAuthorVo.getUserId());
                userServiceApi.saveUserAuthorInfo(saveUserAuthorInfoDto);
            }
        }
    }

}
