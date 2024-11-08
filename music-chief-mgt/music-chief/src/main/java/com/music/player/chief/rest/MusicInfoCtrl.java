package com.music.player.chief.rest;

import com.music.player.chief.biz.MusicBiz;
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
    private MusicBiz musicBiz;
    @Autowired
    private MusicApplyInfoService musicApplyInfoService;
    @Autowired
    private MusicInfoService musicInfoService;


    /**
     * publish the author's music
     */
    @PostMapping("publishMusic")
    public R publishMusic(@RequestBody PublishMusicDto publishMusicDto) {
        musicBiz.publishMusic(publishMusicDto);
        return R.ok();
    }

    /**
     * query music apply list
     */
    @GetMapping("queryMusicApplyList")
    public R queryMusicApplyList(QueryMusicApplyListDto queryMusicApplyListDto) {
        return R.ok(musicApplyInfoService.queryMusicApplyList(queryMusicApplyListDto));
    }

    @GetMapping("queryMusicList")
    public R queryMusicList(QueryMusicListDto queryMusicListDto) {
        return R.ok(musicInfoService.queryMusicList(queryMusicListDto));
    }
}
