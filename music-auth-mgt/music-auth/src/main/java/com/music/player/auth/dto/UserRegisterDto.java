package com.music.player.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户注册实体")
public class UserRegisterDto {

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("登录类型")
    private String loginType;

    @ApiModelProperty("登录账号")
    @NotEmpty(message = "登录账号不能为空")
    private String userName;
}
