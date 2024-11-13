package com.music.player.chief.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.chief.biz.AuthorInfoBiz;
import com.music.player.chief.dto.QueryMusicListDto;
import com.music.player.chief.entity.MusicInfo;
import com.music.player.chief.mapper.MusicInfoMapper;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.chief.service.MusicInfoService;
import com.music.player.chief.vo.QueryMusicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenjia
 */
@Service
public class MusicInfoServiceImpl extends ServiceImpl<MusicInfoMapper, MusicInfo> implements MusicInfoService {

    @Autowired
    private AuthorInfoService authorInfoService;
    @Autowired
    private AuthorInfoBiz authorInfoBiz;


    @Override
    public IPage<QueryMusicListVo> queryMusicList(QueryMusicListDto queryMusicListDto) {
        Page<QueryMusicListVo> page = new Page<>(queryMusicListDto.getPageNum(), queryMusicListDto.getPageSize());
        IPage<QueryMusicListVo> queryMusicListResult = baseMapper.queryMusicList(page, queryMusicListDto);
        queryMusicListResult.getRecords().forEach(queryMusicListVo -> {
            queryMusicListVo.setAuthorName(authorInfoBiz.queryAuthorInfo(queryMusicListVo.getAuthorId()).getAuthorName());
        });
        return queryMusicListResult;
    }
}
