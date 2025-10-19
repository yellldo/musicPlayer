package com.music.player.system.rest;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.DictBiz;
import com.music.player.system.dto.*;
import com.music.player.system.vo.DictCodeVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : DictInfoCtrl<br>
 * Description : DictInfoCtrl<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Slf4j
@RestController
@Validated
@RequestMapping("dictInfo")
public class DictInfoCtrl {

    @Autowired
    private DictBiz dictBiz;

    @PostMapping("create")
    public R<?> createDictCode(@Valid @RequestBody CreateDictDto createDictDto) {
        dictBiz.create(createDictDto);
        return R.ok();
    }

    @PostMapping("createDictCode")
    public R<?> createDictCode(@Valid @RequestBody DictCodeCreateDto dictCodeCreateDto) {
        dictBiz.createDictCode(dictCodeCreateDto);
        return R.ok();
    }

    @PostMapping("dictCodePage")
    public R<PageResult<DictCodeVo>> dictTypePage(@RequestBody DictCodePageDto dictCodePageDto) {
        return dictBiz.dictCodePage(dictCodePageDto);
    }

    @PostMapping("updateDictCode")
    public R<?> updateDictCode(@Valid @RequestBody UpdateDictDto updateDictDto) {
        dictBiz.updateDictCode(updateDictDto);
        return R.ok();
    }

    @PostMapping("deleteDictCode")
    public R<?> dictCodeDelete(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        dictBiz.dictCodeDelete(dictCodeIdDto);
        return R.ok();
    }

    @PostMapping("updateStatus")
    public R<?> updateStatus(@RequestBody DictUpdateStatusDto dictUpdateStatusDto) {
        dictBiz.updateStatus(dictUpdateStatusDto);
        return R.ok();
    }

    @PostMapping("updateDetailStatus")
    public R<?> updateDetailStatus(@RequestBody DictUpdateStatusDto dictUpdateStatusDto) {
        dictBiz.updateDetailStatus(dictUpdateStatusDto);
        return R.ok();
    }

    @PostMapping("queryDictByParentId")
    public R<?> queryDictByParentId(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        return R.ok(dictBiz.queryDictByParentId(dictCodeIdDto));
    }

    @PostMapping("createDict")
    public R<?> createDict(@Valid @RequestBody DictCreateDto dictCreateDto) {
        dictBiz.dictCreate(dictCreateDto);
        return R.ok();
    }

    @PostMapping("deleteDictDetail")
    public R<?> deleteDictDetail(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        dictBiz.deleteDictDetail(dictCodeIdDto);
        return R.ok();
    }
}
