package com.music.player.user.rest;

import com.music.player.user.biz.MemberGroupBiz;
import com.music.player.user.dto.MemberGroupCreateDto;
import com.music.player.user.dto.MemberGroupPageDto;
import com.music.player.user.dto.MemberGroupUpdateDto;
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
@RequestMapping("/user/member-groups")
public class MemberGroupCtrl {

    @Autowired
    private MemberGroupBiz memberGroupBiz;

    @GetMapping
    public R page(MemberGroupPageDto dto) {
        return R.ok(memberGroupBiz.page(dto));
    }

    @GetMapping("/list")
    public R list() {
        return R.ok(memberGroupBiz.list());
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(memberGroupBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody MemberGroupCreateDto dto) {
        memberGroupBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody MemberGroupUpdateDto dto) {
        dto.setId(id);
        memberGroupBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        memberGroupBiz.delete(id);
        return R.ok();
    }
}
