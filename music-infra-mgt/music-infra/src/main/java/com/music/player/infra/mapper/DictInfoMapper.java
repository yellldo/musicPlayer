package com.music.player.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.player.infra.dto.QueryDictInfoListDto;
import com.music.player.infra.dto.QueryParentDictListDto;
import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.vo.DictInfoVo;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName : DictInfoMapper.xml<br>
 * Description : DictInfoMapper.xml<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface DictInfoMapper extends BaseMapper<DictInfo> {


    IPage<DictInfoVo> queryDictInfoList(Page<DictInfoVo> page, @Param("queryDictInfoListDto") QueryDictInfoListDto queryDictInfoListDto);


    IPage<DictInfoVo> queryParentDictList(Page<DictInfoVo> page, @Param("queryParentDictListDto") QueryParentDictListDto queryParentDictListDto);
}
