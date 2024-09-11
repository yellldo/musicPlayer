package com.music.player.infra.api;

import com.music.player.framework.cache.redis.CacheHashKey;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.base.R;
import com.music.player.infra.api.service.dict.DictServiceApi;
import com.music.player.infra.api.service.dict.dto.QueryDictListDto;
import com.music.player.infra.api.service.dict.vo.DictInfoVo;
import com.music.player.infra.biz.DictInfoBiz;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

/**
 * ClassName : DictServiceApiImpl<br>
 * Description : DictServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
@RestController
public class DictServiceApiImpl implements DictServiceApi {

    @Autowired
    private DictInfoBiz dictInfoBiz;
    @Autowired
    private CacheService cacheService;


    @Override
    public R<List<DictInfoVo>> queryDictList(QueryDictListDto queryDictListDto) {
        CacheHashKey cacheHashKey = new CacheHashKey();
        cacheHashKey.setField(queryDictListDto.getDictType());
        if (StringUtils.isNotBlank(queryDictListDto.getDictKey())) {
            cacheHashKey.setKey(queryDictListDto.getDictKey());
        }
        boolean exists = cacheService.hExists(cacheHashKey);
        if (exists) {
            return R.ok(cacheService.hGet(cacheHashKey, true));
        }
        cacheHashKey.setExpire(Duration.ofDays(5));
        List<DictInfoVo> dictInfoVos = dictInfoBiz.queryDictList(queryDictListDto);
        cacheService.hSet(cacheHashKey, dictInfoVos);
        return R.ok(dictInfoVos);
    }
}
