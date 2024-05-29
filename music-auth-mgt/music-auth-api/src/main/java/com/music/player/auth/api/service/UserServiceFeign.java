package com.music.player.auth.api.service;

import com.music.player.auth.api.enums.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName : SysUserServiceFeign<br>
 * Description : SysUserServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-auth")
public interface UserServiceFeign {

//    @PostMapping("/user/login")
//    R<AuthInfo> login(@RequestBody UserLoginDto userLoginDto);
//
//    @PostMapping("/user/register")
//    R<Boolean> regitsrer(@RequestBody UserRegisterDto userRegisterDto);
//
//    @PostMapping("/user/getCode")
//    R<Boolean> getCode(@RequestBody UserGetCodeDto userGetCodeDto);
//
//    @GetMapping("/user/userInfo")
//    R<Boolean> userInfo();
}
