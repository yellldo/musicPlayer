package com.music.player.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : UpdateUserInfoDto<br>
 * Description : UpdateUserInfoDto<br>
 *
 * @author : sj
 * @date : 10/8/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UpdateUserInfoDto {

    @NotNull(message = "用户id不能为空")
    private Long userId;

    private String nickName;

    private String profile;

    private String gender;

    private String birthday;

    private String province;

    private String city;

    private String isArtist;
}
