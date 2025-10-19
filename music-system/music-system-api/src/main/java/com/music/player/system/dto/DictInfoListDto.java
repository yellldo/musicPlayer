package com.music.player.system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DictInfoListDto<br>
 * Description : DictInfoListDto<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
public class DictInfoListDto {

    @NotBlank(message = "字典类型不能为空")
    private String dictType;

    @NotBlank(message = "字典编码不能为空")
    private String dictCode;
}
