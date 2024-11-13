package com.music.player.chief.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.chief.dto.QueryMusicApplyListDto;
import com.music.player.chief.entity.MusicApplyInfo;
import com.music.player.chief.mapper.MusicApplyInfoMapper;
import com.music.player.chief.service.MusicApplyInfoService;
import com.music.player.chief.vo.QueryMusicApplyInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author shenjia
 */
@Service
public class MusicApplyInfoServiceImpl extends ServiceImpl<MusicApplyInfoMapper, MusicApplyInfo> implements MusicApplyInfoService {

    @Override
    public IPage<QueryMusicApplyInfoVo> queryMusicApplyList(QueryMusicApplyListDto queryMusicApplyListDto) {
        Page<QueryMusicApplyInfoVo> page = new Page<>(queryMusicApplyListDto.getPageNum(), queryMusicApplyListDto.getPageSize());
        return baseMapper.queryMusicApplyList(page, queryMusicApplyListDto);
    }
}
