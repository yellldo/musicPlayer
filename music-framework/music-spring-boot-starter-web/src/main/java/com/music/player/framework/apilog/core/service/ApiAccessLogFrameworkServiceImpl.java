package com.music.player.framework.apilog.core.service;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.api.service.ApiAccessLogFeign;
import lombok.RequiredArgsConstructor;

/**
 * ClassName : ApiAccessLogFrameworkServiceImpl<br>
 * Description :  API 访问日志 Framework Service 实现类
 * <p>
 * 基于 {@link ApiAccessLogFeign} 服务，记录访问日志<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogFeign apiAccessLogFeign;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDto reqDTO) {
        apiAccessLogFeign.createApiAccessLog(reqDTO);
    }
}
