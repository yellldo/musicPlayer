package com.music.player.system.rest;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.DictBiz;
import com.music.player.system.dto.*;
import com.music.player.system.vo.DictCodeVo;
import com.music.player.system.vo.DictDetailVo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 创建字典明细
     *
     * @param createDictDto
     * @return
     */
    @PostMapping("create")
    public R<?> createDictCode(@Valid @RequestBody CreateDictDto createDictDto) {
        dictBiz.create(createDictDto);
        return R.ok();
    }

    /**
     * 创建字典编码
     *
     * @param dictCodeCreateDto
     * @return
     */
    @PostMapping("createDictCode")
    public R<?> createDictCode(@Valid @RequestBody DictCodeCreateDto dictCodeCreateDto) {
        dictBiz.createDictCode(dictCodeCreateDto);
        return R.ok();
    }

    /**
     * 根据字典类型分也查询
     *
     * @param dictCodePageDto
     * @return
     */
    @PostMapping("dictCodePage")
    public R<PageResult<DictCodeVo>> dictTypePage(@RequestBody DictCodePageDto dictCodePageDto) {
        return R.ok(dictBiz.dictCodePage(dictCodePageDto));
    }

    /**
     * 根据字典类型查询列表
     *
     * @param dictCodeDto
     * @return
     */
    @PostMapping("queryListByDictCode")
    public R<List<DictDetailVo>> queryListByDictCode(@RequestBody DictCodeDto dictCodeDto) {
        return R.ok(dictBiz.queryListByDictCode(dictCodeDto));
    }


    /**
     * 更新字典信息
     *
     * @param updateDictDto
     * @return
     */
    @PostMapping("updateDictCode")
    public R<?> updateDictCode(@Valid @RequestBody UpdateDictDto updateDictDto) {
        dictBiz.updateDictCode(updateDictDto);
        return R.ok();
    }

    /**
     * 删除字典
     *
     * @param dictCodeIdDto
     * @return
     */
    @PostMapping("deleteDictCode")
    public R<?> dictCodeDelete(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        dictBiz.dictCodeDelete(dictCodeIdDto);
        return R.ok();
    }

    /**
     * 修改字段状态
     *
     * @param dictUpdateStatusDto
     * @return
     */
    @PostMapping("updateStatus")
    public R<?> updateStatus(@RequestBody DictUpdateStatusDto dictUpdateStatusDto) {
        dictBiz.updateStatus(dictUpdateStatusDto);
        return R.ok();
    }

    /**
     * 修改字典明细状态
     *
     * @param dictUpdateStatusDto
     * @return
     */
    @PostMapping("updateDetailStatus")
    public R<?> updateDetailStatus(@RequestBody DictUpdateStatusDto dictUpdateStatusDto) {
        dictBiz.updateDetailStatus(dictUpdateStatusDto);
        return R.ok();
    }

    /**
     * 根据parentId查询字典
     *
     * @param dictCodeIdDto
     * @return
     */
    @PostMapping("queryDictByParentId")
    public R<?> queryDictByParentId(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        return R.ok(dictBiz.queryDictByParentId(dictCodeIdDto));
    }

    /**
     * 创建字典明细
     *
     * @param dictCreateDto
     * @return
     */
    @PostMapping("createDict")
    public R<?> createDict(@Valid @RequestBody DictCreateDto dictCreateDto) {
        dictBiz.dictCreate(dictCreateDto);
        return R.ok();
    }

    /**
     * 删除字典明细
     *
     * @param dictCodeIdDto
     * @return
     */
    @PostMapping("deleteDictDetail")
    public R<?> deleteDictDetail(@Valid @RequestBody DictCodeIdDto dictCodeIdDto) {
        dictBiz.deleteDictDetail(dictCodeIdDto);
        return R.ok();
    }
}
