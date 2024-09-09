package com.music.player.auth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * ClassName : SysUserLoginDto<br>
 * Description : SysUserLoginDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ToString
public class SysUserLoginDto implements Serializable {

    @NotEmpty(message = "请输入登录账号")
    private String loginName;

    /**
     * 这里传的密文
     */
    @NotEmpty(message = "请输入密码")
    private String password;
}
