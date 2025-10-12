package com.music.player.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.mybatis.core.service.IBaseService;
import com.music.player.system.entity.DictInfo;

/**
 * ClassName : DictInfoService<br>
 * Description : DictInfoService<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@DS("system")
public interface DictInfoService extends IBaseService<DictInfo> {
}
