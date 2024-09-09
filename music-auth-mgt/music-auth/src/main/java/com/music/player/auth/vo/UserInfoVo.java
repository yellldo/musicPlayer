package com.music.player.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : UserInfoVo<br>
 * Description : UserInfoVo<br>
 *
 * @author : sj
 * @date : 2024/9/6
 */
@Setter
@Getter
@ToString
@ApiModel("用户信息返回实体")
public class UserInfoVo implements Serializable {

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户状态")
    private String userStatus;
}
