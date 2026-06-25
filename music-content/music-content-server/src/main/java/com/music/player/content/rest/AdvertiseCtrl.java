package com.music.player.content.rest;

import com.music.player.content.biz.AdvertiseBiz;
import com.music.player.content.dto.AdvertiseCreateDto;
import com.music.player.content.dto.AdvertisePageDto;
import com.music.player.content.dto.AdvertiseUpdateDto;
import com.music.player.framework.common.base.R;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : AdvertiseCtrl<br>
 * Description : 广告投放管理<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@RestController
@RequestMapping("/content/advertises")
public class AdvertiseCtrl {

    @Autowired
    private AdvertiseBiz advertiseBiz;

    @GetMapping
    public R page(AdvertisePageDto dto) {
        return R.ok(advertiseBiz.page(dto));
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(advertiseBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody AdvertiseCreateDto dto) {
        advertiseBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody AdvertiseUpdateDto dto) {
        dto.setId(id);
        advertiseBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        advertiseBiz.delete(id);
        return R.ok();
    }

    @PutMapping("/{id}/status")
    public R toggleStatus(@PathVariable Long id) {
        advertiseBiz.toggleStatus(id);
        return R.ok();
    }
}
