package com.music.player.adm.dto;

import com.music.player.adm.vo.UserDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * ClassName : JwtUser<br>
 * Description : JwtUser<br>
 *
 * @author : sj
 * @date : 2024/3/30
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString(callSuper = true)
public class JwtUser extends UserDetails {

    private Long userId;

    private String password;

    private String phone;

    private String email;

    private String userStatus;

    private String loginType;

}
