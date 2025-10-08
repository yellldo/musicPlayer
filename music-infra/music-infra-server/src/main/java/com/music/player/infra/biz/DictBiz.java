package com.music.player.infra.biz;

import com.music.player.framework.common.base.PageResult;
import com.music.player.framework.common.base.R;
import com.music.player.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.music.player.infra.convert.DictConvert;
import com.music.player.infra.dto.CreateDictDto;
import com.music.player.infra.dto.DictPageDto;
import com.music.player.infra.entity.DictInfo;
import com.music.player.infra.service.DictInfoService;
import com.music.player.infra.vo.DictInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ClassName : DictBiz<br>
 * Description : DictBiz<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Service
public class DictBiz {

    @Autowired
    private DictInfoService dictInfoService;

    public void create(CreateDictDto createDictDto) {
        dictInfoService.save(DictConvert.INSTANT.create(createDictDto));
    }

    public R<PageResult<DictInfoVo>> page(DictPageDto dictPageDto) {
        PageResult<DictInfo> result = dictInfoService.selectPage(dictPageDto, new LambdaQueryWrapperX<DictInfo>()
                .eqIfPresent(DictInfo::getDictKey, dictPageDto.getDictKey())
                .eqIfPresent(DictInfo::getDictType, dictPageDto.getDictType()));
        return R.ok(DictConvert.INSTANT.convertPage(result));
    }
}
