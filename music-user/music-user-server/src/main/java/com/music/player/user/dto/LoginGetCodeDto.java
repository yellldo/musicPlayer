package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : LoginGetCodeDto<br>
 * Description : LoginGetCodeDto<br>
 *
 * @author : sj
 * @date : 10/9/25
 */
@Setter
@Getter
@ToString
public class LoginGetCodeDto {

    @NotBlank(message = "手机号不能为空")
    private String phone;

    private String type = "1";
}
