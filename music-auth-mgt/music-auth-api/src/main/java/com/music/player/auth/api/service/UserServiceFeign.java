package com.music.player.auth.api.service;

import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.api.dto.UserRegisterDto;
import com.music.player.common.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : SysUserServiceFeign<br>
 * Description : SysUserServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = "music-auth", path = "${server.servlet.context-path}")
public interface UserServiceFeign {


    @PostMapping("/login")
    R login(@RequestBody UserLoginDto userLoginDto);


    @PostMapping("/register")
    R regitsrer(@RequestBody UserRegisterDto userRegisterDto);

    @PostMapping("/getCode")
    R getCode(@RequestBody UserGetCodeDto userGetCodeDto);

}
