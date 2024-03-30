package com.music.player.auth.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : AuthInfo<br>
 * Description : AuthInfo<br>
 *
 * @author : sj
 * @date : 2024/3/30
 */
@Setter
@Getter
@ToString
public class AuthInfo implements Serializable {

    private String token;

    private JwtUser jwtUser;

    public AuthInfo(String token, JwtUser jwtUser) {
        this.token = token;
        this.jwtUser = jwtUser;
    }
}
