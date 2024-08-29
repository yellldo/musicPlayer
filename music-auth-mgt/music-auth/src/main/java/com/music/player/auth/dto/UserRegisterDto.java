package com.music.player.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * ClassName : UserRegisterDto<br>
 * Description : 前台用户注册<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Setter
@Getter
@ToString
public class UserRegisterDto {

    private String phone;

    private String email;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String loginType;

    @NotEmpty(message = "用户名不能为空")
    private String userName;
}
