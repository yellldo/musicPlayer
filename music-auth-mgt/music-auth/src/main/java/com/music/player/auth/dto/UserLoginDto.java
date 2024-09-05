package com.music.player.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * ClassName : UserLoginDto<br>
 * Description : 前台用户登录<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Setter
@Getter
@ToString
public class UserLoginDto {

    @NotEmpty(message = "请选择登录方式")
    private String loginType;

    @NotEmpty(message = "请输入账号")
    private String loginName;

    @NotEmpty(message = "请输入密码")
    private String password;
}
