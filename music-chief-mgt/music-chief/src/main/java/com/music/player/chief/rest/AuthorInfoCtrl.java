package com.music.player.chief.rest;

import com.music.player.chief.biz.AuthorInfoBiz;
import com.music.player.chief.dto.QueryAuthorListDto;
import com.music.player.chief.dto.UpdateAuthorInfoDto;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.framework.common.base.R;
import com.music.player.web.annotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenjia
 */
@Api(tags = "作者管理")
@RestController
@RequestMapping("authInfo")
public class AuthorInfoCtrl {

    @Autowired
    private AuthorInfoService authorInfoService;
    @Autowired
    private AuthorInfoBiz authorInfoBiz;

    @LogRecord(value = "查询作者列表")
    @ApiOperation("查询作者列表")
    @GetMapping("queryAuthorList")
    public R queryAuthorList(QueryAuthorListDto queryAuthorListDto) {
        return R.ok(authorInfoService.queryAuthorList(queryAuthorListDto));
    }

    @LogRecord(value = "更新作者信息")
    @ApiOperation("更新作者信息")
    @PostMapping("updateAuthorInfo")
    public R updateAuthorInfo(@RequestBody UpdateAuthorInfoDto updateAuthorInfoDto) {
        authorInfoBiz.updateAuthorInfo(updateAuthorInfoDto);
        return R.ok();
    }


}
