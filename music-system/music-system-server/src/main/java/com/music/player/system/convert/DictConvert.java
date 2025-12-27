package com.music.player.system.convert;

import com.music.player.framework.common.base.PageResult;
import com.music.player.system.dto.*;
import com.music.player.system.entity.DictDetail;
import com.music.player.system.entity.DictInfo;
import com.music.player.system.vo.DictDetailVo;
import com.music.player.system.vo.DictInfoVo;
import com.music.player.system.vo.DictCodeVo;
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

    PageResult<DictCodeVo> convertDictTypePage(PageResult<DictInfo> pageResult);

    List<DictCodeVo> convertDictTypeList(List<DictInfo> list);

    List<DictInfoVo> converList(List<DictInfo> dictInfos);

    List<DictDetailVo> converDetailList(List<DictDetail> dictInfos);

    DictInfo update(UpdateDictDto updateDictDto);

    DictInfo updateStatus(DictUpdateStatusDto dictUpdateStatusDto);

    DictDetail updateDetailStatus(DictUpdateStatusDto dictUpdateStatusDto);

    DictInfo createDictCode(DictCodeCreateDto dictCodeCreateDto);

    DictDetail createDict(DictCreateDto dictCreateDto);

}
