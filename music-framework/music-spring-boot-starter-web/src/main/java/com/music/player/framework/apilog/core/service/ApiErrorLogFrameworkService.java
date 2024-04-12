package com.music.player.framework.apilog.core.service;

import com.music.player.infra.api.dto.ApiErrorLogCreateReqDto;

/**
 * ClassName : ApiErrorLogFrameworkService<br>
 * Description : ApiErrorLogFrameworkService<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
public interface ApiErrorLogFrameworkService {

    /**
     * 创建 API 错误日志
     *
     * @param reqDTO API 错误日志
     */
    void createApiErrorLog(ApiErrorLogCreateReqDto reqDTO);
}
