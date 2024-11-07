package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import com.music.player.infra.biz.DictInfoBiz;
import com.music.player.infra.dto.*;
import com.music.player.infra.service.DictInfoService;
//import com.music.player.web.annotation.LogRecord;
import com.music.player.web.annotation.LogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName : DictInfoCtrl<br>
 * Description : 字典<br>
 *
 * @author : sj
 * @date : 2024/9/6
 */
@Api(tags = "字典管理")
@RestController
@RequestMapping("dictInfo")
public class DictInfoCtrl {

    @Autowired
    private DictInfoService dictInfoService;
    @Autowired
    private DictInfoBiz dictInfoBiz;

    @LogRecord(value = "查询字典列表")
    @ApiOperation("查询字典列表")
    @GetMapping("queryDictInfoList")
    public R queryDictInfoList(QueryDictInfoListDto queryDictInfoListDto) {
        return R.ok(dictInfoService.queryDictInfoList(queryDictInfoListDto));
    }

    @ApiOperation("查询父级字典列表")
    @GetMapping("queryParentDictList")
    public R queryParentDictList(QueryParentDictListDto queryParentDictListDto) {
        return R.ok(dictInfoService.queryParentDictList(queryParentDictListDto));
    }

    @LogRecord(value = "新增字典项")
    @ApiOperation("新增字典项")
    @PostMapping("saveDictInfo")
    public R saveDictInfo(@RequestBody SaveDictInfoDto saveDictInfoDto, HttpServletRequest request) {
        dictInfoBiz.saveDictInfo(saveDictInfoDto, request);
        return R.ok();
    }

    @LogRecord(value = "删除字典")
    @ApiOperation("删除字典")
    @PostMapping("deleteDict")
    public R deleteDict(@RequestBody DeleteDictDto deleteDictDto) {
        dictInfoBiz.deleteDict(deleteDictDto);
        return R.ok();
    }

    @LogRecord(value = "更新字典")
    @ApiOperation("更新字典")
    @PostMapping("modifyDictInfo")
    public R modifyDictInfo(@RequestBody ModifyDictInfoDto modifyDictInfoDto) {
        dictInfoBiz.modifyDictInfo(modifyDictInfoDto);
        return R.ok();
    }

}
