package com.music.player.user.rest;

import com.music.player.user.biz.MemberBiz;
import com.music.player.user.dto.MemberCreateDto;
import com.music.player.user.dto.MemberPageDto;
import com.music.player.user.dto.MemberUpdateDto;
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
 * ClassName : MemberCtrl<br>
 * Description : 会员管理<br>
 *
 * @author : sj
 * @date : 6/24/26
 */
@RestController
@RequestMapping("/user/members")
public class MemberCtrl {

    @Autowired
    private MemberBiz memberBiz;

    @GetMapping
    public R page(MemberPageDto dto) {
        return R.ok(memberBiz.page(dto));
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(memberBiz.detail(id));
    }

    @PostMapping
    public R create(@Valid @RequestBody MemberCreateDto dto) {
        memberBiz.create(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R update(@PathVariable Long id, @Valid @RequestBody MemberUpdateDto dto) {
        dto.setId(id);
        memberBiz.update(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        memberBiz.delete(id);
        return R.ok();
    }

    @PutMapping("/{id}/status")
    public R toggleStatus(@PathVariable Long id) {
        memberBiz.toggleStatus(id);
        return R.ok();
    }
}
