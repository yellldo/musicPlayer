package com.music.player.system.convert;

import com.music.player.framework.common.base.PageResult;
import com.music.player.system.dto.CreateDictDto;
import com.music.player.system.dto.UpdateDictDto;
import com.music.player.system.entity.DictInfo;
import com.music.player.system.vo.DictInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * ClassName : DictConvert<br>
 * Description : DictConvert<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Mapper
public interface DictConvert {

    DictConvert INSTANT = Mappers.getMapper(DictConvert.class);

    DictInfo create(CreateDictDto createDictDto);

    PageResult<DictInfoVo> convertPage(PageResult<DictInfo> pageResult);

    List<DictInfoVo> converList(List<DictInfo> dictInfos);

    DictInfo update(UpdateDictDto updateDictDto);
}
