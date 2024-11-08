package com.music.player.auth.api.service.user;

import com.music.player.auth.api.service.user.dto.ObtainUserInfoDto;
import com.music.player.auth.api.enums.ApiConstants;
import com.music.player.auth.api.service.user.dto.SaveUserAuthorInfoDto;
import com.music.player.auth.api.service.user.vo.UserInfoVo;
import com.music.player.framework.common.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : UserServiceApi<br>
 * Description : UserServiceApi<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface UserServiceApi {


    /**
     * obtain user information
     */
    @PostMapping("user/obtainUserInfo")
    R<UserInfoVo> obtainUserInfo(@RequestBody ObtainUserInfoDto obtainUserInfoDto);


    /**
     * save user information
     */
    @PostMapping("saveUserAuthorInfo")
    void saveUserAuthorInfo(@RequestBody SaveUserAuthorInfoDto saveUserAuthorInfoDto);
}