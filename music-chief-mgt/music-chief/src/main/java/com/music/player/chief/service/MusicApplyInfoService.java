package com.music.player.chief.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.chief.dto.QueryMusicApplyListDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.vo.QueryMusicApplyInfoVo;

public interface MusicApplyInfoService extends IService<MusicApplyInfo> {

    IPage<QueryMusicApplyInfoVo> queryMusicApplyList(QueryMusicApplyListDto queryMusicApplyListDto);
}
