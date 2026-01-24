package com.music.player.content.rest;

import com.music.player.content.biz.ArtistsAuditBiz;
import com.music.player.content.dto.ArtistsAuditAuditDto;
import com.music.player.content.dto.ArtistsAuditPageDto;
import com.music.player.content.dto.CreateArtistsAuditDto;
import com.music.player.framework.common.base.R;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : ArtistsAuditCtrl<br>
 * Description : ArtistsAuditCtrl<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@RestController
@RequestMapping("artistsAudit")
public class ArtistsAuditCtrl {

    @Autowired
    private ArtistsAuditBiz artistsAuditBiz;

    @PostMapping("page")
    public R page(@RequestBody ArtistsAuditPageDto artistsAuditPageDto) {
        return R.ok(artistsAuditBiz.page(artistsAuditPageDto));
    }


    @PostMapping("audit")
    public R audit(@RequestBody ArtistsAuditAuditDto artistsAuditAuditDto) {
        artistsAuditBiz.audit(artistsAuditAuditDto);
        return R.ok();
    }

    @PostMapping("create")
    public R create(@Valid @RequestBody CreateArtistsAuditDto createArtistsAuditDto) {
        artistsAuditBiz.create(createArtistsAuditDto);
        return R.ok();
    }
}
