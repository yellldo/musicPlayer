package com.music.player.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : RegisterUserDto<br>
 * Description : RegisterUserDto<br>
 *
 * @author : sj
 * @date : 10/10/25
 */
@Setter
@Getter
@ToString
public class RegisterUserDto {

    @NotNull(message = "手机号不能为空")
    private String phone;

    private String profile;

    @NotNull(message = "昵称不能为空")
    private String nickName;

    private String gender;

    private String avatar;

    private String province;

    private String city;

    private String birthday;
}
