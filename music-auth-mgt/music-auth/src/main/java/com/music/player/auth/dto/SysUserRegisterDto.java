package com.music.player.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
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
@ApiModel("后台用户注册实体")
public class SysUserRegisterDto implements Serializable {

    @ApiModelProperty("登录账号")
    @NotEmpty(message = "登录账号不能为空")
    private String loginName;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

}
