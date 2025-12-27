package com.music.player.system.service;

import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.dto.DictCodeDto;
import com.music.player.system.entity.DictDetail;
import com.music.player.system.vo.DictDetailVo;

import java.util.List;

/**
 * ClassName : DictDetailService<br>
 * Description : DictDetailService<br>
 *
 * @author : sj
 * @date : 10/19/25
 */
public interface DictDetailService extends IBaseService<DictDetail> {


    List<DictDetailVo> queryDictByDictCode(DictCodeDto dictCodeDto);
}
