package com.music.player.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * ClassName : SysUserRegisterDto<br>
 * Description : SysUserRegisterDto<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
public class SysUserRegisterDto implements Serializable {

    @NotNull(message = "登录名不能为空")
    private String loginName;

    @NotNull(message = "密码不能为空")
    private String password;

    private String nickName;

}
