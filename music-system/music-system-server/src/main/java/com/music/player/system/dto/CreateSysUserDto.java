package com.music.player.system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * ClassName : CreateSysUserDto<br>
 * Description : CreateSysUserDto<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
public class CreateSysUserDto {

    @NotBlank(message = "登录账号不能为空")
    private String loginName;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    private String userStatus;

    private String email;

    private String phone;

    private String remark;

    private List<Long> roleList;
}
