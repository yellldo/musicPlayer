package com.music.player.web.event;

import com.music.player.infra.api.service.log.dto.SaveSysLogDto;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName : SysLogEventSource<br>
 * Description : SysLogEventSource<br>
 *
 * @author : sj
 * @date : 2024/9/9
 */
@Setter
@Getter
public class SysLogEventSource extends SaveSysLogDto {

    /**
     * 参数重写成object
     */
    private Object body;
}
