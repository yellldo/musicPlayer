package com.music.player.chief.biz;

import com.music.player.chief.api.enums.ErrorCodeConstants;
import com.music.player.chief.convert.MusicInfoConvert;
import com.music.player.chief.dto.ApprovalMusicDto;
import com.music.player.chief.dto.PublishMusicDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.entity.MusicInfo;
import com.music.player.chief.service.MusicApplyInfoService;
import com.music.player.chief.service.MusicInfoService;
import com.music.player.framework.common.support.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MusicInfoBiz {

    @Autowired
    private MusicApplyInfoService musicApplyInfoService;
    @Autowired
    private MusicInfoService musicInfoService;

    /**
     * Publish the music.
     * Although it's publishing music, the request data actually installed.
     */
    public void publishMusic(PublishMusicDto publishMusicDto) {
        MusicApplyInfo musicApplyInfo = MusicInfoConvert.INSTANT.publishMusic(publishMusicDto);
        musicApplyInfoService.save(musicApplyInfo);
    }

    /**
     * Approval music.
     */
    public void approvalMusic(ApprovalMusicDto approvalMusicDto) {
        MusicApplyInfo musicApplyInfo = musicApplyInfoService.getById(approvalMusicDto.getMusicApplyId());
        if (musicApplyInfo == null) {
            throw new BizException(ErrorCodeConstants.AUTHOR_NOT_EXISTS);
        }
        musicApplyInfo.setMusicApplyStatus(approvalMusicDto.getMusicApplyStatus());
        musicApplyInfo.setMusicApplyRemark(approvalMusicDto.getMusicApplyStatus());
        musicApplyInfoService.updateById(musicApplyInfo);
        // Check if the music is existing
        MusicInfo musicInfo = musicInfoService.getById(musicApplyInfo.getMusicId());
        if (musicInfo == null) {
            musicInfo = MusicInfoConvert.INSTANT.musicApplyInfo(musicApplyInfo);
            musicInfoService.save(musicInfo);
        } else {
            musicInfo = MusicInfoConvert.INSTANT.musicApplyInfo(musicApplyInfo);
            musicInfo.setUpdateTime(new Date());
            musicInfoService.updateById(musicInfo);
        }
    }
}
