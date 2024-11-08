package com.music.player.chief.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.chief.dto.QueryMusicApplyListDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.vo.QueryMusicApplyInfoVo;
import org.apache.ibatis.annotations.Param;

public interface MusicApplyInfoMapper extends BaseMapper<MusicApplyInfo> {

    IPage<QueryMusicApplyInfoVo> queryMusicApplyList(Page<QueryMusicApplyInfoVo> page, @Param("queryMusicApplyListDto") QueryMusicApplyListDto queryMusicApplyListDto);
}
