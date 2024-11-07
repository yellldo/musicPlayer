package com.music.player.auth.api.service.user;

import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.enums.ApiConstants;
import com.music.player.auth.api.service.user.dto.RelevanceAuthorDto;
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
     * 获取用户信息
     *
     * @param getUserInfoDto
     * @return
     */
    @PostMapping("user/getUserInfo")
    R<UserInfoVo> getUserInfo(@RequestBody GetUserInfoDto getUserInfoDto);


    @PostMapping("saveUserAuthorInfo")
    void saveUserAuthorInfo(@RequestBody SaveUserAuthorInfoDto saveUserAuthorInfoDto);

    /**
     * 关联作者
     *
     * @param relevanceAuthorDto
     */
    @PostMapping("relevanceAuthor")
    void relevanceAuthor(@RequestBody RelevanceAuthorDto relevanceAuthorDto);

}
