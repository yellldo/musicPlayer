package com.music.player.content.biz;

import com.music.player.content.constant.PlaylistAuditConstants;
import com.music.player.content.convert.PlaylistAuditConvert;
import com.music.player.content.dto.PlaylistAuditAuditDto;
import com.music.player.content.dto.PlaylistAuditPageDto;
import com.music.player.content.entity.PlaylistAudit;
import com.music.player.content.enmus.ErrorCodeConstants;
import com.music.player.content.service.PlaylistAuditService;
import com.music.player.content.vo.PlaylistAuditVo;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.constants.CommonConstants;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * ClassName : PlaylistAuditBiz<br>
 * Description : 歌单审核业务层<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Component
public class PlaylistAuditBiz {

    @Autowired
    private PlaylistAuditService playlistAuditService;

    public PageResult<PlaylistAuditVo> page(PlaylistAuditPageDto dto) {
        PageResult<PlaylistAudit> pageResult = playlistAuditService.selectPage(dto, new LambdaQueryWrapperX<PlaylistAudit>()
                .likeIfPresent(PlaylistAudit::getPlaylistName, dto.getPlaylistName())
                .eqIfPresent(PlaylistAudit::getAuditStatus, dto.getAuditStatus())
                .eq(PlaylistAudit::getIsDelete, CommonConstants.STATUS_NOT_DEL));
        return PlaylistAuditConvert.INSTANT.convertPage(pageResult);
    }

    public PlaylistAuditVo detail(Long id) {
        PlaylistAudit entity = playlistAuditService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_NOT_FOUND);
        }
        return PlaylistAuditConvert.INSTANT.toVo(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void approve(Long id) {
        PlaylistAudit entity = playlistAuditService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_NOT_FOUND);
        }
        if (!PlaylistAuditConstants.STATUS_PENDING.equals(entity.getAuditStatus())) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_DONE);
        }
        PlaylistAudit update = new PlaylistAudit();
        update.setId(id);
        update.setAuditStatus(PlaylistAuditConstants.STATUS_APPROVED);
        update.setAuditTime(LocalDateTime.now());
        playlistAuditService.updateById(update);
    }

    @Transactional(rollbackFor = Exception.class)
    public void reject(PlaylistAuditAuditDto dto) {
        PlaylistAudit entity = playlistAuditService.getById(dto.getId());
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_NOT_FOUND);
        }
        if (!PlaylistAuditConstants.STATUS_PENDING.equals(entity.getAuditStatus())) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_DONE);
        }
        PlaylistAudit update = new PlaylistAudit();
        update.setId(dto.getId());
        update.setAuditStatus(PlaylistAuditConstants.STATUS_REJECTED);
        update.setAuditOpinion(dto.getAuditOpinion());
        update.setAuditTime(LocalDateTime.now());
        playlistAuditService.updateById(update);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        PlaylistAudit entity = playlistAuditService.getById(id);
        if (entity == null) {
            throw new BusinessException(ErrorCodeConstants.PLAYLIST_AUDIT_NOT_FOUND);
        }
        playlistAuditService.removeById(id);
    }
}
