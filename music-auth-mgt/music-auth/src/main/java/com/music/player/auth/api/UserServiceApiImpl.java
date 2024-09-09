package com.music.player.auth.api;

import com.music.player.auth.api.service.user.UserServiceApi;
import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.service.user.vo.UserInfoVo;
import com.music.player.auth.biz.UserBiz;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserServiceApiImpl<br>
 * Description : UserServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@RestController
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserBiz userBiz;

    @Override
    public R<UserInfoVo> getUserInfo(GetUserInfoDto getUserInfoDto) {
        return R.ok(userBiz.getUserInfo(getUserInfoDto));
    }
}
