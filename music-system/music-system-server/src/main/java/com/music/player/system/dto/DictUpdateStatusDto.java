package com.music.player.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictUpdateStatusDto<br>
 * Description : DictUpdateStatusDto<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString(callSuper = true)
public class DictUpdateStatusDto extends DictCodeIdDto {

    private String dictStatus;
}
