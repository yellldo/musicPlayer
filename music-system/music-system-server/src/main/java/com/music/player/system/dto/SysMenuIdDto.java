package com.music.player.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysMenuIdDto<br>
 * Description : SysMenuIdDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysMenuIdDto {

    @NotNull(message = "参数异常")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;
}
