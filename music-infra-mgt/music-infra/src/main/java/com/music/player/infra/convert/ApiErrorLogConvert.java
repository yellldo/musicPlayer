package com.music.player.infra.convert;

import com.music.player.infra.api.dto.ApiErrorLogCreateReqDto;
import com.music.player.infra.entity.ApiErrorLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : ApiErrorLogConvert<br>
 * Description : ApiErrorLogConvert<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANT = Mappers.getMapper(ApiErrorLogConvert.class);


    ApiErrorLog create(ApiErrorLogCreateReqDto apiErrorLogCreateReqDto);
}
