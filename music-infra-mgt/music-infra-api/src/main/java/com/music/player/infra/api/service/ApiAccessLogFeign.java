package com.music.player.infra.api.service;

import com.music.player.framework.common.domain.CommonResult;
import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * ClassName : ApiAccessLogFeign<br>
 * Description : API 访问日志<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Tag(name = "API 访问日志")
@FeignClient(value = "music-infra", path = "${server.servlet.context-path}")
public interface ApiAccessLogFeign {


    @PostMapping("/create")
    @Operation(summary = "创建 API 访问日志")
    CommonResult<Boolean> createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDto apiAccessLogCreateReqDto);

}
