package com.music.player.infra.api.service;

import com.music.player.infra.api.dto.ApiAccessLogCreateReqDto;
import com.music.player.infra.api.enmus.ApiConstants;
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
@FeignClient(value = ApiConstants.NAME, path = "/music-infra")
public interface ApiAccessLogFeign {


    @PostMapping("/api/log/create")
    void createApiAccessLog(@Valid @RequestBody ApiAccessLogCreateReqDto apiAccessLogCreateReqDto);

}
