package com.music.player.chief.rest;

import com.music.player.chief.dto.QueryAuthorListDto;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.framework.common.base.R;
import com.music.player.web.annotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "作者管理")
@RestController
@RequestMapping("authInfo")
public class AuthorInfoCtrl {

    @Autowired
    private AuthorInfoService authorInfoService;

    @LogRecord(value = "查询作者列表")
    @ApiOperation("查询作者列表")
    @GetMapping("queryAuthorList")
    public R queryAuthorList(QueryAuthorListDto queryAuthorListDto) {
        return R.ok(authorInfoService.queryAuthorList(queryAuthorListDto));
    }


}
