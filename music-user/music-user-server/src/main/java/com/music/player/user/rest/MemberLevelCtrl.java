package com.music.player.user.rest;

import com.music.player.user.biz.MemberLevelBiz;
import com.music.player.user.dto.MemberLevelCreateDto;
import com.music.player.user.dto.MemberLevelPageDto;
import com.music.player.user.dto.MemberLevelUpdateDto;
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

@RestController
@RequestMapping("/user/member-levels")
public class MemberLevelCtrl {

    @Autowired
    private MemberLevelBiz memberLevelBiz;

    @GetMapping
    public R page(MemberLevelPageDto dto) {
        return R.ok(memberLevelBiz.page(dto));
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(memberLevelBiz.list());
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(memberLevelBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody MemberLevelCreateDto dto) {
        memberLevelBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody MemberLevelUpdateDto dto) {
        dto.setId(id);
        memberLevelBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        memberLevelBiz.delete(id);
        return R.ok();
    }
}
