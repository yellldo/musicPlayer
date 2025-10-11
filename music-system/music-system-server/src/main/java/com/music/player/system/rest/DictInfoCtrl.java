package com.music.player.system.rest;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.system.biz.DictBiz;
import com.music.player.system.dto.CreateDictDto;
import com.music.player.system.dto.DictPageDto;
import com.music.player.system.dto.UpdateDictDto;
import com.music.player.system.vo.DictInfoVo;
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
    public R createDict(@Valid @RequestBody CreateDictDto createDictDto) {
        dictBiz.create(createDictDto);
        return R.ok();
    }

    @PostMapping("page")
    public R<PageResult<DictInfoVo>> getDictPage(@RequestBody DictPageDto dictPageDto) {
        return dictBiz.page(dictPageDto);
    }

    @PostMapping("update")
    public R update(@Valid @RequestBody UpdateDictDto updateDictDto) {
        dictBiz.update(updateDictDto);
        return R.ok();
    }

}
