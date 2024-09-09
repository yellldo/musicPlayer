package com.music.player.infra.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.infra.dto.QueryDictInfoListDto;
import com.music.player.infra.dto.QueryParentDictListDto;
import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.vo.DictInfoVo;

/**
 * ClassName : DictInfoService<br>
 * Description : DictInfoService<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface DictInfoService extends IService<DictInfo> {


    IPage<DictInfoVo> queryDictInfoList(QueryDictInfoListDto queryDictInfoListDto);


    IPage<DictInfoVo> queryParentDictList(QueryParentDictListDto queryParentDictListDto);


}
