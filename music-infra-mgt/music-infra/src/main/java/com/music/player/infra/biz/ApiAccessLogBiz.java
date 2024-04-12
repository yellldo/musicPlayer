package com.music.player.infra.biz;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.convert.ApiAccessLogConvert;
import com.music.player.infra.entity.ApiAccessLog;
import com.music.player.infra.service.ApiAccessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * ClassName : ApiAccessLogBiz<br>
 * Description : ApiAccessLogBiz<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Service
public class ApiAccessLogBiz {

    @Autowired
    private ApiAccessLogService apiAccessLogService;


    public void createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDto apiAccessLogCreateReqDto) {
        ApiAccessLog apiAccessLog = ApiAccessLogConvert.INSTANT.create(apiAccessLogCreateReqDto);
        apiAccessLogService.save(apiAccessLog);
    }
}
