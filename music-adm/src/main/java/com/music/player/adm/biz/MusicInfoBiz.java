package com.music.player.adm.biz;

import com.music.player.chief.api.service.music.MusicApplyInfoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicInfoBiz {

    @Autowired
    private MusicApplyInfoServiceApi musicApplyInfoServiceApi;


}
