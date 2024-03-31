package com.music.player.infra.convert;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.entity.ApiAccessLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ClassName : ApiAccessLogConvert<br>
 * Description : ApiAccessLogConvert<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Mapper
public interface ApiAccessLogConvert {

    ApiAccessLogConvert INSTANT = Mappers.getMapper(ApiAccessLogConvert.class);


    ApiAccessLog create(ApiAccessLogCreateReqDto apiAccessLogCreateReqDto);


}
