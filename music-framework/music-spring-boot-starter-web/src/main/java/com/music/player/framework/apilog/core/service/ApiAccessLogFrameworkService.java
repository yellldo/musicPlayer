package com.music.player.framework.apilog.core.service;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;

/**
 * ClassName : ApiAccessLogFrameworkService<br>
 * Description : API 访问日志 Framework Service 接口<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
public interface ApiAccessLogFrameworkService {

    /**
     * 创建 API 访问日志
     *
     * @param reqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDto reqDTO);
}
