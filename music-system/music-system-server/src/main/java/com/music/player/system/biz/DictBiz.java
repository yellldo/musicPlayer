package com.music.player.system.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.framework.common.exception.base.BusinessException;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.system.constants.RedisConstants;
import com.music.player.system.convert.DictConvert;
import com.music.player.system.dto.CreateDictDto;
import com.music.player.system.dto.DictInfoListDto;
import com.music.player.system.dto.DictPageDto;
import com.music.player.system.dto.UpdateDictDto;
import com.music.player.system.enmus.ErrorCodeConstants;
import com.music.player.system.entity.DictInfo;
import com.music.player.system.service.DictInfoService;
import com.music.player.system.vo.DictInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * ClassName : DictBiz<br>
 * Description : DictBiz<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@DS("system")
@Service
public class DictBiz {

    @Autowired
    private DictInfoService dictInfoService;
    @Autowired
    private RedisOps redisOps;

    public void create(CreateDictDto createDictDto) {
        dictInfoService.save(DictConvert.INSTANT.create(createDictDto));
    }

    public R<PageResult<DictInfoVo>> page(DictPageDto dictPageDto) {
        PageResult<DictInfo> result = dictInfoService.selectPage(dictPageDto, new LambdaQueryWrapperX<DictInfo>()
                .eqIfPresent(DictInfo::getDictKey, dictPageDto.getDictKey())
                .eqIfPresent(DictInfo::getDictType, dictPageDto.getDictType()));
        return R.ok(DictConvert.INSTANT.convertPage(result));
    }

    public void update(UpdateDictDto updateDictDto) {
        DictInfo dictInfo = dictInfoService.getById(updateDictDto.getId());
        if (BeanUtil.isEmpty(dictInfo)) {
            throw new BusinessException(ErrorCodeConstants.DICT_NOT_EXISTS);
        }
        String dictType = dictInfo.getDictType();
        String key = RedisConstants.DICT_KEY + dictType;
        redisOps.del(key);
        dictInfo = DictConvert.INSTANT.update(updateDictDto);
        dictInfoService.updateById(dictInfo);
        redisOps.del(key);
    }

    public List<DictInfoVo> dictInfoList(DictInfoListDto dictInfoListDto) {
        List<DictInfo> dictInfos = dictInfoService.selectList(new LambdaQueryWrapperX<DictInfo>().eqIfPresent(DictInfo::getDictType, dictInfoListDto.getDictType()));
        List<DictInfoVo> dictInfoVos = DictConvert.INSTANT.converList(dictInfos);
        String key = RedisConstants.DICT_KEY + dictInfoListDto.getDictType();
        redisOps.set(key, dictInfoVos, false);
        return dictInfoVos;
    }
}
