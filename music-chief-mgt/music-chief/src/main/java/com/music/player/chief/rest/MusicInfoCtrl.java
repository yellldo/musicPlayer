package com.music.player.chief.rest;

import com.music.player.chief.biz.MusicInfoBiz;
import com.music.player.chief.dto.ApprovalMusicDto;
import com.music.player.chief.dto.QueryMusicApplyListDto;
import com.music.player.chief.dto.PublishMusicDto;
import com.music.player.chief.dto.QueryMusicListDto;
import com.music.player.chief.service.MusicApplyInfoService;
import com.music.player.chief.service.MusicInfoService;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("musicInfo")
public class MusicInfoCtrl {

    @Autowired
    private MusicInfoBiz musicInfoBiz;
    @Autowired
    private MusicApplyInfoService musicApplyInfoService;
    @Autowired
    private MusicInfoService musicInfoService;


    /**
     * Publish the author's music
     */
    @PostMapping("publishMusic")
    public R publishMusic(@RequestBody PublishMusicDto publishMusicDto) {
        musicInfoBiz.publishMusic(publishMusicDto);
        return R.ok();
    }

    /**
     * Query the list of music apply
     */
    @GetMapping("queryMusicApplyList")
    public R queryMusicApplyList(QueryMusicApplyListDto queryMusicApplyListDto) {
        return R.ok(musicApplyInfoService.queryMusicApplyList(queryMusicApplyListDto));
    }

    /**
     * Query the list of music
     */
    @GetMapping("queryMusicList")
    public R queryMusicList(QueryMusicListDto queryMusicListDto) {
        return R.ok(musicInfoService.queryMusicList(queryMusicListDto));
    }

    /**
     * Approval music
     */
    @PostMapping("approvalMusic")
    public R approvalMusic(@RequestBody ApprovalMusicDto approvalMusicDto) {
        return R.ok();
    }
}
