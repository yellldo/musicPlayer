package com.music.player.chief.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.chief.dto.QueryMusicListDto;
import com.music.player.chief.entity.MusicInfo;
import com.music.player.chief.vo.QueryMusicListVo;
import org.apache.ibatis.annotations.Param;

public interface MusicInfoMapper extends BaseMapper<MusicInfo> {

    IPage<QueryMusicListVo> queryMusicList(Page<QueryMusicListVo> page, @Param("queryMusicListDto") QueryMusicListDto queryMusicListDto);

}
