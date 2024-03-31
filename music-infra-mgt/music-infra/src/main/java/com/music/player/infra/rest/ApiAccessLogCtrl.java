package com.music.player.infra.rest;

import com.music.player.framework.common.domain.CommonResult;
import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : ApiAccessLogCtrl<br>
 * Description : ApiAccessLogCtrl<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@RestController
public class ApiAccessLogCtrl implements ApiAccessLogFeign {


    @Override
    public CommonResult<Boolean> createApiAccessLog(ApiAccessLogCreateReqDto apiAccessLogCreateReqDto) {
        return null;
    }
}
