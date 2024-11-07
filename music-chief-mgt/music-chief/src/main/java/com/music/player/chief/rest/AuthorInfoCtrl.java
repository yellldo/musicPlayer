package com.music.player.chief.rest;

import com.music.player.chief.dto.QueryAuthorList;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authInfo")
public class AuthorInfoCtrl {


    @Autowired
    private AuthorInfoService authorInfoService;


    @GetMapping("queryAuthorList")
    public R queryAuthorList(QueryAuthorList queryAuthorList) {
        return R.ok();
    }


}
