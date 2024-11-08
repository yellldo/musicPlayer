package com.music.player.chief.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.chief.dto.QueryMusicListDto;
import com.music.player.chief.entity.MusicInfo;
import com.music.player.chief.vo.QueryMusicListVo;

public interface MusicInfoService extends IService<MusicInfo> {

    IPage<QueryMusicListVo> queryMusicList(QueryMusicListDto queryMusicListDto);
}
