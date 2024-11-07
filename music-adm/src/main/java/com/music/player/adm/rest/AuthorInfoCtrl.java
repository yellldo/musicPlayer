package com.music.player.adm.rest;

import com.music.player.adm.biz.AuthorBiz;
import com.music.player.adm.dto.AdmAuditAuthorDto;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authorInfo")
public class AuthorInfoCtrl {

    @Autowired
    private AuthorBiz authorBiz;

    @PostMapping("auditAuthor")
    public R auditAuthor(@RequestBody AdmAuditAuthorDto admAuditAuthorDto) {
        authorBiz.auditAuthor(admAuditAuthorDto);
        return R.ok();
    }

}
