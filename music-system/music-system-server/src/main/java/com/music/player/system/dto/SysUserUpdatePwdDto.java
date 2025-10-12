package com.music.player.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : SysUserUpdatePwdDto<br>
 * Description : SysUserUpdatePwdDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysUserUpdatePwdDto {

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "参数异常")
    private Long userId;

    @NotBlank(message = "请输入密码")
    private String password;
}
