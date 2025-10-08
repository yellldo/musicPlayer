package com.music.player.infra.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : CreateDictDto<br>
 * Description : CreateDictDto<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Setter
@Getter
@ToString
public class CreateDictDto {

    private Long parentId;

    @NotNull(message = "字典类型不能为空")
    private String dictType;

    @NotNull(message = "字典key不能为空")
    private String dictKey;

    @NotNull(message = "字典值不能为空")
    private String dictValue;

    private String dictRemark;

}
