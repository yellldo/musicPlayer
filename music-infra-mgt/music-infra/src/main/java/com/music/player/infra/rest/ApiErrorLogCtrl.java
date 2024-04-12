package com.music.player.infra.rest;

import com.music.player.framework.common.domain.CommonResult;
import com.music.player.infra.api.dto.ApiErrorLogCreateReqDto;
import com.music.player.infra.api.service.ApiErrorLogFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : ApiErrorLogCtrl<br>
 * Description : ApiErrorLogCtl<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@RestController
public class ApiErrorLogCtrl implements ApiErrorLogFeign {

    @Override
    public CommonResult<Boolean> createApiErrorLog(ApiErrorLogCreateReqDto createDTO) {
        return null;
    }
}
