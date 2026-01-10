package com.music.player.content.api;

import com.music.player.content.dto.CreateArtistsAuditDto;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.FeignConstants;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : ArtistsAuditApi<br>
 * Description : ArtistsAuditApi<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@FeignClient(value = FeignConstants.MUSIC_CONTENT, path = FeignConstants.MUSIC_CONTENT_URL)
public interface ArtistsAuditApi {


    /**
     * 申请成功歌手
     *
     * @param createArtistsAuditDto
     * @return
     */
    R<Void> createArtists(@Valid @RequestBody CreateArtistsAuditDto createArtistsAuditDto);

}
