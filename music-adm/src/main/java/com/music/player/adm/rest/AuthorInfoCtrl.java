package com.music.player.adm.rest;

import com.music.player.adm.biz.AuthorInfoBiz;
import com.music.player.adm.dto.AdmApprovalAuthorDto;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authorInfo")
public class AuthorInfoCtrl {

    @Autowired
    private AuthorInfoBiz authorInfoBiz;

    /**
     * the author audit
     */
    @PostMapping("approvalAuthor")
    public R approvalAuthor(@RequestBody AdmApprovalAuthorDto admApprovalAuthorDto) {
        authorInfoBiz.approvalAuthor(admApprovalAuthorDto);
        return R.ok();
    }

}
