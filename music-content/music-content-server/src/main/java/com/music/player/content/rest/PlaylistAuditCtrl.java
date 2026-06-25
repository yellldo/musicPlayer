package com.music.player.content.rest;

import com.music.player.content.biz.PlaylistAuditBiz;
import com.music.player.content.dto.PlaylistAuditAuditDto;
import com.music.player.content.dto.PlaylistAuditPageDto;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : PlaylistAuditCtrl<br>
 * Description : 歌单审核管理<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@RestController
@RequestMapping("/content/playlist-audits")
public class PlaylistAuditCtrl {

    @Autowired
    private PlaylistAuditBiz playlistAuditBiz;

    @GetMapping
    public R page(PlaylistAuditPageDto dto) {
        return R.ok(playlistAuditBiz.page(dto));
    }

    @GetMapping("/{id}")
    public R detail(@PathVariable Long id) {
        return R.ok(playlistAuditBiz.detail(id));
    }

    @PostMapping("/{id}/approve")
    public R approve(@PathVariable Long id) {
        playlistAuditBiz.approve(id);
        return R.ok();
    }

    @PostMapping("/{id}/reject")
    public R reject(@PathVariable Long id, @RequestBody PlaylistAuditAuditDto dto) {
        dto.setId(id);
        playlistAuditBiz.reject(dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        playlistAuditBiz.delete(id);
        return R.ok();
    }
}
