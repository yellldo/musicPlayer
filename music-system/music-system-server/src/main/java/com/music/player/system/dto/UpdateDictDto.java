package com.music.player.system.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : UpdateDictDto<br>
 * Description : UpdateDictDto<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
public class UpdateDictDto {

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "参数异常")
    private Long id;

    private String dictCode;

    private String dictType;

    private String dictName;

    private String dictRemark;

    private String dictStatus;

    private Integer sort;

    private String isDelete;
}
