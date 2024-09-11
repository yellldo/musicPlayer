package com.music.player.infra.api.service.dict.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryDictListDto<br>
 * Description : QueryDictListDto<br>
 *
 * @author : sj
 * @date : 2024/9/10
 */
@Setter
@Getter
@ToString
public class QueryDictListDto implements Serializable {

    private String dictType;

    private String dictKey;
}
