package com.music.player.infra.api.service;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.dto.SaveLogDto;
import com.music.player.infra.api.enmus.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : SysLogServiceFeign<br>
 * Description : SysLogServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-infra")
public interface SysLogServiceFeign {

    /**
     * 保存日志
     *
     * @param saveLogDto 日志实体
     * @return succes、false
     */
    @PostMapping("/log/save")
    R<Boolean> saveLog(@RequestBody SaveLogDto saveLogDto);


}
