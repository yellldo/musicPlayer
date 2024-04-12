package com.music.player.infra.rest;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import com.music.player.infra.biz.ApiAccessLogBiz;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ApiAccessLogBiz apiAccessLogBiz;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDto apiAccessLogCreateReqDto) {
        apiAccessLogBiz.createApiAccessLog(apiAccessLogCreateReqDto);
    }
}
