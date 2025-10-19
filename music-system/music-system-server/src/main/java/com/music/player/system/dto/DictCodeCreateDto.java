package com.music.player.system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : DictTypeCreateDto<br>
 * Description : DictTypeCreateDto<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString
public class DictCodeCreateDto implements Serializable {

    @NotBlank(message = "请选择字典类型")
    private String dictType;

    @NotEmpty(message = "请输入字典名称")
    private String dictName;

    @NotEmpty(message = "字典编码")
    private String dictCode;

    private String dictRemark;

    private String dictStatus;

    private int sort;
}
