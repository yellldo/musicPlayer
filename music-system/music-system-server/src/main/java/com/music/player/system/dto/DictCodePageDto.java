package com.music.player.system.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictPageDto<br>
 * Description : DictPageDto<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class DictCodePageDto extends QueryRequestParam {

    private String dictType;

    private String dictStatus;

}
