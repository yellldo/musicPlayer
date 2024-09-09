package com.music.player.log.event;

import com.music.player.infra.api.service.log.dto.SysLogDto;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName : SysLogEventSource<br>
 * Description : SysLogEventSource<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@Setter
@Getter
public class SysLogEventSource extends SysLogDto {

    /**
     * 参数重写成object
     */
    private Object body;
}
