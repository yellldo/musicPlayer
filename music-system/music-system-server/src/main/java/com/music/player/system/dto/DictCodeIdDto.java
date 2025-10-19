package com.music.player.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictCodeIdDto<br>
 * Description : DictCodeIdDto<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString
public class DictCodeIdDto {

    @NotNull
    private Long id;
}
