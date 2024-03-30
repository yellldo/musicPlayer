package com.music.player.auth.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

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
public class JwtUser implements UserDetails {


    private Long userId;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private String userStatus;

    private String loginType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
