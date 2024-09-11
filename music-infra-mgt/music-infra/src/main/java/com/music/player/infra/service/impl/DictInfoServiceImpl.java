package com.music.player.infra.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.infra.api.service.dict.dto.QueryDictListDto;
import com.music.player.infra.api.service.dict.vo.DictInfoVo;
import com.music.player.infra.dto.QueryDictInfoListDto;
import com.music.player.infra.dto.QueryParentDictListDto;
import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.mapper.DictInfoMapper;
import com.music.player.infra.service.DictInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : DictInfoServiceImpl<br>
 * Description : DictInfoServiceImpl<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Service
public class DictInfoServiceImpl extends ServiceImpl<DictInfoMapper, DictInfo> implements DictInfoService {

    @Override
    public IPage<DictInfoVo> queryDictInfoList(QueryDictInfoListDto queryDictInfoListDto) {
        Page<DictInfoVo> page = new Page<>(queryDictInfoListDto.getPageNum(), queryDictInfoListDto.getPageSize());
        return baseMapper.queryDictInfoList(page, queryDictInfoListDto);
    }

    @Override
    public IPage<DictInfoVo> queryParentDictList(QueryParentDictListDto queryParentDictListDto) {
        Page<DictInfoVo> page = new Page<>(queryParentDictListDto.getPageNum(), queryParentDictListDto.getPageSize());
        return baseMapper.queryParentDictList(page, queryParentDictListDto);
    }

    @Override
    public List<DictInfoVo> queryDictList(QueryDictListDto queryDictListDto) {
        return baseMapper.queryDictList(queryDictListDto);
    }
}
