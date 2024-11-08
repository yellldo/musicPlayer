package com.music.player.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户登录实体")
public class UserLoginDto {

    @ApiModelProperty("登录方式")
    @NotEmpty(message = "登录方式不能为空")
    private String loginType;

    @ApiModelProperty("登录账号")
    @NotEmpty(message = "登录账号不能为空")
    private String loginName;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
