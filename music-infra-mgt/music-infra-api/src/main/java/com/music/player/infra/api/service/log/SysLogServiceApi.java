package com.music.player.infra.api.service.log;

import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import com.music.player.infra.api.enmus.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : SysLogServiceApi<br>
 * Description : SysLogServiceApi<br>
 *
 * @author : sj
 * @date : 2024/5/19
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface SysLogServiceApi {

    String PREFIX = "sysLog/";

    /**
     * 保存日志
     *
     * @param saveLogDto 日志实体
     */
    @PostMapping(PREFIX + "save")
    void saveSysLog(@RequestBody SaveSysLogDto saveLogDto);


}
