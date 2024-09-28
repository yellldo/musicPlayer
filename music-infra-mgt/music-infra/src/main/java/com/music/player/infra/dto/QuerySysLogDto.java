package com.music.player.infra.dto;

import com.music.player.framework.common.base.QueryRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : QuerySysLogDto<br>
 * Description : QuerySysLogDto<br>
 *
 * @author : sj
 * @date : 2024/9/22
 */
@Setter
@Getter
@ToString
public class QuerySysLogDto extends QueryRequest {

    private String logType;

    private String userType;

}
