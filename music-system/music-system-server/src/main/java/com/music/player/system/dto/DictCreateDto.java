package com.music.player.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictCreateDto<br>
 * Description : DictCreateDto<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString
public class DictCreateDto {

    @NotNull(message = "参数异常")
    private Long parentId;

    private String dictLabel;

    private String dictValue;

    private Integer sort;

    private String dictStatus;

    private String dictRemark;

}
