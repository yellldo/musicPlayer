package com.music.player.infra.convert;

import com.music.player.infra.dto.ModifyDictInfoDto;
import com.music.player.infra.dto.SaveDictInfoDto;
import com.music.player.infra.entity.DictInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : DictInfoConvert<br>
 * Description : DictInfoConvert<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Mapper
public interface DictInfoConvert {

    DictInfoConvert INSTANT = Mappers.getMapper(DictInfoConvert.class);


    DictInfo saveDictInfo(SaveDictInfoDto saveDictInfoDto);


    DictInfo modifyDictInfo(ModifyDictInfoDto modifyDictInfoDto);

}
