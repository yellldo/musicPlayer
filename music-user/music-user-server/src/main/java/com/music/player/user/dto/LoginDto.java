package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : LoginDto<br>
 * Description : LoginDto<br>
 *
 * @author : sj
 * @date : 10/9/25
 */
@Setter
@Getter
@ToString
public class LoginDto {

    @NotBlank(message = "手机号不能为空")
    private String phone;

    private Integer code;
}
