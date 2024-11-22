package com.music.player.adm.rest;

import com.music.player.adm.biz.MusicInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("musicInfo")
@RestController
public class MusicInfoCtrl {

    @Autowired
    private MusicInfoBiz musicInfoBiz;


}
