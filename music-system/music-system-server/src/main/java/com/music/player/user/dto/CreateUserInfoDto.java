package com.music.player.user.dto;

import com.music.player.framework.common.validation.Email;
import com.music.player.framework.common.validation.Mobile;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : CreateUserInfoDto<br>
 * Description : CreateUserInfoDto<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
public class CreateUserInfoDto {

    @NotNull(message = "昵称不能为空")
    private String nickName;

    @Mobile
    @NotNull(message = "手机号不能为空")
    private String phone;

    @Email
    private String email;

    private String gender;

    private String avatar;

    private String birthday;

    private String province;

    private String city;

    private String profile;
}
