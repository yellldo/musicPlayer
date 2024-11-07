package com.music.player.chief.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.chief.dto.QueryAuthorListDto;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.vo.QueryAuthorListVo;

public interface AuthorInfoService extends IService<AuthorInfo> {

    IPage<QueryAuthorListVo> queryAuthorList(QueryAuthorListDto queryAuthorListDto);
}
