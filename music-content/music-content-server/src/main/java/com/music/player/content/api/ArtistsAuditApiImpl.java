package com.music.player.content.api;

import com.music.player.content.biz.ArtistsAuditBiz;
import com.music.player.content.convert.ArtistsAuditConvert;
import com.music.player.content.dto.CreateArtistsAuditDto;
import com.music.player.content.service.ArtistsAuditService;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : ArtistsAuditApiImpl<br>
 * Description : ArtistsAuditApiImpl<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Service
public class ArtistsAuditApiImpl implements ArtistsAuditApi {

    @Autowired
    private ArtistsAuditBiz artistsAuditBiz;
    @Autowired
    private ArtistsAuditService artistsAuditService;

    @Override
    public R<Void> createArtists(CreateArtistsAuditDto createArtistsAuditDto) {
        artistsAuditService.save(ArtistsAuditConvert.INSTANT.create(createArtistsAuditDto));
        return R.ok();
    }
}
