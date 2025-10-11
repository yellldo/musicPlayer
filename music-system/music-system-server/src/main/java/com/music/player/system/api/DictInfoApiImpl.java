package com.music.player.system.api;


import com.music.player.framework.common.base.R;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.biz.DictBiz;
import com.music.player.system.constants.RedisConstants;
import com.music.player.system.dto.DictInfoListDto;
import com.music.player.system.vo.DictInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName : DictInfoApiImpl<br>
 * Description : DictInfoApiImpl<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@RestController
public class DictInfoApiImpl implements DictInfoApi {

    @Autowired
    private DictBiz dictBiz;
    @Autowired
    private RedisOps redisOps;

    @Override
    public R<List<DictInfoVo>> dictInfoList(DictInfoListDto dictInfoListDto) {
        String dictType = dictInfoListDto.getDictType();
        String key = RedisConstants.DICT_KEY + dictType;
        if (redisOps.exists(key)) {
            return R.ok(redisOps.get(key, false));
        }
        return R.ok(dictBiz.dictInfoList(dictInfoListDto));
    }
}
