package com.music.player.auth.api.service.user;

import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.enums.ApiConstants;
import com.music.player.auth.api.service.user.vo.GetUserInfoVo;
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

//    @PostMapping("/user/login")
//    R<AuthInfo> login(@RequestBody UserLoginDto userLoginDto);
//
//    @PostMapping("/user/getCode")
//    R<Boolean> getCode(@RequestBody UserGetCodeDto userGetCodeDto);
//
//    @GetMapping("/user/userInfo")
//    R<Boolean> userInfo();

    @PostMapping("user/getUserInfo")
    R<GetUserInfoVo> getUserInfo(@RequestBody GetUserInfoDto getUserInfoDto);
}
