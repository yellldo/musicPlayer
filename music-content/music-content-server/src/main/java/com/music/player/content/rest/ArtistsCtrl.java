package com.music.player.content.rest;

import com.music.player.content.biz.ArtistsBiz;
import com.music.player.content.dto.ArtistsPageDto;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : ArtistsCtrl<br>
 * Description : ArtistsCtrl<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@RestController
@RequestMapping("artists")
public class ArtistsCtrl {

    @Autowired
    private ArtistsBiz artistsBiz;


    @PostMapping("page")
    public R page(ArtistsPageDto artistsPageDto) {
        return R.ok(artistsBiz.page(artistsPageDto));
    }




}
