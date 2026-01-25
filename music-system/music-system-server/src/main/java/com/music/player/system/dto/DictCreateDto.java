package com.music.player.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    private String dictLabel;

    private String dictValue;

    private Integer sort;

    private String dictStatus;

    private String dictRemark;

}
