package com.music.player.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysRoleIdDto<br>
 * Description : SysRoleIdDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysRoleIdDto {

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "参数异常")
    private Long roleId;
}
