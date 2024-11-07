package com.music.player.chief.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.chief.dto.QueryAuthorListDto;
import com.music.player.chief.entity.AuthorInfo;
import com.music.player.chief.vo.QueryAuthorListVo;
import org.apache.ibatis.annotations.Param;

public interface AuthorInfoMapper extends BaseMapper<AuthorInfo> {

    IPage<QueryAuthorListVo> queryAuthorList(Page<QueryAuthorListVo> page, @Param("queryAuthorListDto") QueryAuthorListDto queryAuthorListDto);
}
