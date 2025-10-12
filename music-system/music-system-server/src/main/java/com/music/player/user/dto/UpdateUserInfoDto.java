package com.music.player.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class UpdateUserInfoDto extends UserInfoIdDto {

    private String nickName;

    private String profile;

    private String gender;

    private String birthday;

    private String province;

    private String city;
}
