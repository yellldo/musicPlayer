package com.music.player.system.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @NotBlank(message = "请输入登录账号")
    private String loginName;

    private String nickName;

    private String remark;
}
