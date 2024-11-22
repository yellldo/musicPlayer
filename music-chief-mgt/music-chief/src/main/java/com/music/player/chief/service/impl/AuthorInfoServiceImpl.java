package com.music.player.chief.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.chief.dto.QueryAuthorListDto;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.mapper.AuthorInfoMapper;
import com.music.player.chief.service.AuthorInfoService;
import com.music.player.chief.vo.QueryAuthorListVo;
import org.springframework.stereotype.Service;

/**
 * @author shenjia
 */
@Service
public class AuthorInfoServiceImpl extends ServiceImpl<AuthorInfoMapper, AuthorInfo> implements AuthorInfoService {


    @Override
    public IPage<QueryAuthorListVo> queryAuthorList(QueryAuthorListDto queryAuthorListDto) {
        Page<QueryAuthorListVo> page = new Page<>(queryAuthorListDto.getPageNum(), queryAuthorListDto.getPageSize());
        return baseMapper.queryAuthorList(page, queryAuthorListDto);
    }
}
