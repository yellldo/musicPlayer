package com.music.player.adm.dto;

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

    @NotEmpty(message = "登录账号不能为空")
    private String loginName;

    /**
     * 这里传的密文
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
}
