package com.music.player.content.rest;

import com.music.player.content.biz.ActivityBiz;
import com.music.player.content.dto.ActivityCreateDto;
import com.music.player.content.dto.ActivityPageDto;
import com.music.player.content.dto.ActivityUpdateDto;
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
 * ClassName : ActivityCtrl<br>
 * Description : 活动运营管理<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@RestController
@RequestMapping("/content/activities")
public class ActivityCtrl {

    @Autowired
    private ActivityBiz activityBiz;

    @GetMapping
    public R page(ActivityPageDto dto) {
        return R.ok(activityBiz.page(dto));
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(activityBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody ActivityCreateDto dto) {
        activityBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody ActivityUpdateDto dto) {
        dto.setId(id);
        activityBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        activityBiz.delete(id);
        return R.ok();
    }

    @PutMapping("/{id}/status")
    public R toggleStatus(@PathVariable Long id) {
        activityBiz.toggleStatus(id);
        return R.ok();
    }
}
