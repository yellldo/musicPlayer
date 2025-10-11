package com.music.player.system.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "参数异常")
    private Long id;

    private String dictValue;

    private String dictRemark;

    private String dictStatus;

    private String isDelete;
}
