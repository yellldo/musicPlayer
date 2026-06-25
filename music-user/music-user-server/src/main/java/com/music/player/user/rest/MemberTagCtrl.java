package com.music.player.user.rest;

import com.music.player.user.biz.MemberTagBiz;
import com.music.player.user.dto.MemberTagCreateDto;
import com.music.player.user.dto.MemberTagPageDto;
import com.music.player.user.dto.MemberTagUpdateDto;
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
@RequestMapping("/user/member-tags")
public class MemberTagCtrl {

    @Autowired
    private MemberTagBiz memberTagBiz;

    @GetMapping
    public R page(MemberTagPageDto dto) {
        return R.ok(memberTagBiz.page(dto));
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(memberTagBiz.list());
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(memberTagBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody MemberTagCreateDto dto) {
        memberTagBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody MemberTagUpdateDto dto) {
        dto.setId(id);
        memberTagBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        memberTagBiz.delete(id);
        return R.ok();
    }
}
