package com.music.player.chief.api.service.music;

import com.music.player.chief.api.enums.ApiConstants;
import com.music.player.framework.common.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface MusicApplyInfoServiceApi {

    String PREFIX = "/musicInfo/";


    @PostMapping("publishMusic")
    R publishMusic();
}
