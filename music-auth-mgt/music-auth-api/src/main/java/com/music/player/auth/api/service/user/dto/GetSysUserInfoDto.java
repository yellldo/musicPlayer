package com.music.player.auth.api.service.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : GetSysUserInfoDto<br>
 * Description : GetSysUserInfoDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class GetSysUserInfoDto {

    private String token;
}
