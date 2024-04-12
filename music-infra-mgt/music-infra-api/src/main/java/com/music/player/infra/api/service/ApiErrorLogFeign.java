package com.music.player.infra.api.service;

import com.music.player.framework.common.domain.CommonResult;
import com.music.player.infra.api.dto.ApiErrorLogCreateReqDto;
import com.music.player.infra.api.enmus.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * ClassName : ApiErrorLogFeign<br>
 * Description : ApiErrorLogFeign<br>
 *
 * @author : sj
 * @date : 2024/4/6
 */
@FeignClient(value = ApiConstants.NAME, path = "${server.servlet.context-path}")
public interface ApiErrorLogFeign {

    @PostMapping("/api/log/error/create")
    @Operation(summary = "创建 API 异常日志")
    CommonResult<Boolean> createApiErrorLog(@Valid @RequestBody ApiErrorLogCreateReqDto createDTO);
}
