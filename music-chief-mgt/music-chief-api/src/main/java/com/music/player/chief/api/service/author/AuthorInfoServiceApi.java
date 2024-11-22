package com.music.player.chief.api.service.author;

import com.music.player.chief.api.enums.ApiConstants;
import com.music.player.chief.api.service.author.dto.ApprovalAuthorDto;
import com.music.player.chief.api.service.author.dto.AuthenticatedDto;
import com.music.player.chief.api.service.author.dto.FetchAuthorInfoDto;
import com.music.player.chief.api.service.author.vo.ApprovalAuthorVo;
import com.music.player.chief.api.service.author.vo.FetchAuthorInfoVo;
import com.music.player.framework.common.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface AuthorInfoServiceApi {

    String PREFIX = "/author/";

    @PostMapping(PREFIX + "authenticated")
    void authenticated(@RequestBody @Valid AuthenticatedDto authenticatedDto);

    @PostMapping(PREFIX + "approvalAuthor")
    R<ApprovalAuthorVo> approvalAuthor(@RequestBody ApprovalAuthorDto approvalAuthorDto);

    @GetMapping(PREFIX + "fetchUserInfo")
    R<FetchAuthorInfoVo> fetchAuthorInfo(FetchAuthorInfoDto fetchAuthorInfoDto);

}
