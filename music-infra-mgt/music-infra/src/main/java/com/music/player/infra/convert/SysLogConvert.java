package com.music.player.infra.convert;

import com.music.player.infra.api.dto.SaveLogDto;
import com.music.player.infra.entity.SysLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : SysLogConvert<br>
 * Description : SysLogConvert<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@Mapper
public interface SysLogConvert {

    SysLogConvert INSTANT = Mappers.getMapper(SysLogConvert.class);

    SysLog saveLog(SaveLogDto saveLogDto);


}
