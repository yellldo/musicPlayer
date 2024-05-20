package com.music.player.auth.api.service;

import com.music.player.auth.api.dto.AuthInfo;
import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.auth.api.enums.ApiConstants;
import com.music.player.framework.common.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : SysUserServiceFeign<br>
 * Description : SysUserServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-auth")
public interface UserServiceFeign {

    @PostMapping("/user/login")
    R<AuthInfo> login(@RequestBody UserLoginDto userLoginDto);

    @PostMapping("/user/register")
    R<Boolean> regitsrer(@RequestBody UserRegisterDto userRegisterDto);

    @PostMapping("/user/getCode")
    R<Boolean> getCode(@RequestBody UserGetCodeDto userGetCodeDto);

    @GetMapping("/user/userInfo")
    R<Boolean> userInfo();
}
