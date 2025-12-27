package com.music.player.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.impl.BaseServiceImpl;
import com.music.player.system.dto.DictCodeDto;
import com.music.player.system.entity.DictDetail;
import com.music.player.system.mapper.DictDetailMapper;
import com.music.player.system.service.DictDetailService;
import com.music.player.system.vo.DictDetailVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName : DictDetailServiceImpl<br>
 * Description : DictDetailServiceImpl<br>
 *
 * @author : sj
 * @date : 10/19/25
 */
@Service
@DS("system")
public class DictDetailServiceImpl extends BaseServiceImpl<DictDetailMapper, DictDetail> implements DictDetailService {


    @Override
    public List<DictDetailVo> queryDictByDictCode(DictCodeDto dictCodeDto) {
        return baseMapper.queryDictByDictCode(dictCodeDto);
    }
}
