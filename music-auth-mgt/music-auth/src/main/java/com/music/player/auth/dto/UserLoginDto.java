package com.music.player.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private String loginType;

    private String loginName;

    private String password;
}
