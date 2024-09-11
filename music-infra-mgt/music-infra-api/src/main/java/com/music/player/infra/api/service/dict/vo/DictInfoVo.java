package com.music.player.infra.api.service.dict.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : DictInfoVo<br>
 * Description : DictInfoVo<br>
 *
 * @author : sj
 * @date : 2024/9/10
 */
@Setter
@Getter
@ToString
public class DictInfoVo implements Serializable {

    private String dictType;

    private String dictKey;

    private String dictValue;
}
