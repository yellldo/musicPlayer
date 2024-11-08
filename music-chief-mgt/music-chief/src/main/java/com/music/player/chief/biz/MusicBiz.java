package com.music.player.chief.biz;

import com.music.player.chief.convert.MusicInfoConvert;
import com.music.player.chief.dto.PublishMusicDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.service.MusicApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicBiz {

    @Autowired
    private MusicApplyInfoService musicApplyInfoService;

    /**
     * Publish the music
     * Although it's publishing music, the request data actually installed
     */
    public void publishMusic(PublishMusicDto publishMusicDto) {
        MusicApplyInfo musicApplyInfo = MusicInfoConvert.INSTANT.publishMusic(publishMusicDto);
        musicApplyInfoService.save(musicApplyInfo);
    }
}
