package com.music.player.content.biz;

import com.music.player.content.constant.ArtistsAuditConstants;
import com.music.player.content.convert.ArtistsAuditConvert;
import com.music.player.content.convert.ArtistsConvert;
import com.music.player.content.dto.ArtistsAuditAuditDto;
import com.music.player.content.dto.ArtistsAuditPageDto;
import com.music.player.content.dto.CreateArtistsAuditDto;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.entity.Artists;
import com.music.player.content.entity.ArtistsAudit;
import com.music.player.content.service.ArtistsAuditService;
import com.music.player.content.service.ArtistsService;
import com.music.player.content.vo.ArtistsAuditVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.user.api.UserInfoApi;
import com.music.player.user.dto.QueryUserDto;
import com.music.player.user.dto.UpdateUserArtistFlagDto;
import com.music.player.user.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private UserInfoApi userInfoApi;


    public PageResult<ArtistsAuditVo> page(ArtistsAuditPageDto artistsAuditPageDto) {
        PageResult<ArtistsAudit> artistsAuditPageResult = artistsAuditService.selectPage(artistsAuditPageDto, new LambdaQueryWrapperX<ArtistsAudit>()
                .eqIfPresent(ArtistsAudit::getAuditStatus, artistsAuditPageDto.getAuditStatus())
                .eqIfPresent(ArtistsAudit::getAuditType, artistsAuditPageDto.getAuditType())
                .eq(ArtistsAudit::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        PageResult<ArtistsAuditVo> artistsAuditVoPageResult = ArtistsAuditConvert.INSTANT.convertPage(artistsAuditPageResult);

        List<Long> userList = artistsAuditVoPageResult.getList().stream().map(ArtistsAuditVo::getUserId).toList();
        R<Map<String, UserInfoVo>> userInfoVoMapR = userInfoApi.queryUserByUserId(new QueryUserDto().setUserIdList(userList));
        artistsAuditVoPageResult.getList().forEach(artistsAuditVo -> {
            UserInfoVo userInfoVo = userInfoVoMapR.getData().get(String.valueOf(artistsAuditVo.getUserId()));
            if (userInfoVo != null) {
                artistsAuditVo.setUserName(userInfoVo.getNickName());
            }
        });
        return artistsAuditVoPageResult;
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
            UpdateUserArtistFlagDto updateUserArtistFlagDto = new UpdateUserArtistFlagDto()
                    .setIsArtist("")
                    .setUserId(artists.getUserId());
            userInfoApi.updateUserArtistFlag(updateUserArtistFlagDto);
        }
    }

    public void create(CreateArtistsAuditDto createArtistsAuditDto) {
        long count = artistsAuditService.selectCount(new LambdaQueryWrapperX<ArtistsAudit>()
                .eq(ArtistsAudit::getIsDelete, CommonConstants.STATUS_NOT_DEL)
                .eq(ArtistsAudit::getUserId, createArtistsAuditDto.getUserId())
                .eq(ArtistsAudit::getAuditStatus, ArtistsAuditConstants.ARTISTS_AUDITS_STATUS_INIT));
        if (count > 0) {
            throw new BusinessException(ErrorCodeConstants.ARTISTS_AUDIT_EXISTS);
        }

        ArtistsAudit artistsAudit = ArtistsAuditConvert.INSTANT.create(createArtistsAuditDto);
        artistsAudit.setAuditType(ArtistsAuditConstants.ARTISTS_TYPE_CREATE);
        artistsAuditService.save(artistsAudit);
    }

}
