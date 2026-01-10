package com.music.player.content.biz;

import com.music.player.content.constant.ArtistsAuditConstants;
import com.music.player.content.convert.ArtistsAuditConvert;
import com.music.player.content.convert.ArtistsConvert;
import com.music.player.content.dto.ArtistsAuditAuditDto;
import com.music.player.content.dto.ArtistsAuditPageDto;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.entity.Artists;
import com.music.player.content.entity.ArtistsAudit;
import com.music.player.content.service.ArtistsAuditService;
import com.music.player.content.service.ArtistsService;
import com.music.player.content.vo.ArtistsAuditVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * ClassName : ArtistsAuditBiz<br>
 * Description : ArtistsAuditBiz<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@Component
public class ArtistsAuditBiz {

    @Autowired
    private ArtistsAuditService artistsAuditService;
    @Autowired
    private ArtistsService artistsService;


    public PageResult<ArtistsAuditVo> page(ArtistsAuditPageDto artistsAuditPageDto) {
        PageResult<ArtistsAudit> artistsAuditPageResult = artistsAuditService.selectPage(artistsAuditPageDto, new LambdaQueryWrapperX<ArtistsAudit>()
                .eqIfPresent(ArtistsAudit::getAuditStatus, artistsAuditPageDto.getAuditStatus())
                .eqIfPresent(ArtistsAudit::getAuditType, artistsAuditPageDto.getAuditType())
                .eq(ArtistsAudit::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return ArtistsAuditConvert.INSTANT.convertPage(artistsAuditPageResult);
    }


    @Transactional(rollbackFor = Exception.class)
    public void audit(ArtistsAuditAuditDto artistsAuditAuditDto) {
        ArtistsAudit origin = artistsAuditService.getById(artistsAuditAuditDto.getId());
        if (!ArtistsAuditConstants.ARTISTS_AUDITS_STATUS_INIT.equals(origin.getAuditStatus())) {
            throw new BusinessException(ErrorCodeConstants.ARTISTS_AUDIT_DONE);
        }

        ArtistsAudit audit = ArtistsAuditConvert.INSTANT.audit(artistsAuditAuditDto);
        if (ArtistsAuditConstants.ARTISTS_AUDITS_STATUS_CANCEL.equals(artistsAuditAuditDto.getAuditStatus())) {
            audit.setWithdrawnTime(LocalDateTime.now());
        }
        audit.setAuditedTime(LocalDateTime.now());
        artistsAuditService.updateById(audit);
        if (ArtistsAuditConstants.ARTISTS_AUDITS_STATUS_PASS.equals(artistsAuditAuditDto.getAuditStatus())) {
            Artists artists = ArtistsConvert.INSTANT.create(origin);

            artistsService.save(artists);
        }


    }

}
