package com.music.player.auth.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private String password;

    private String loginType;

    private String userName;
}
