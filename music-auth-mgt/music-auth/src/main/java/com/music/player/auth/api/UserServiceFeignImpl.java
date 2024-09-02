package com.music.player.auth.api;

import com.music.player.auth.api.service.user.UserServiceFeign;
import com.music.player.auth.api.service.user.dto.GetUserInfoDto;
import com.music.player.auth.api.service.user.vo.GetUserInfoVo;
import com.music.player.auth.biz.UserBiz;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserServiceFeignImpl<br>
 * Description : UserServiceFeignImpl<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@RestController
public class UserServiceFeignImpl implements UserServiceFeign {

    @Autowired
    private UserBiz userBiz;

    @Override
    public R<GetUserInfoVo> getUserInfo(GetUserInfoDto getUserInfoDto) {
        return R.ok(userBiz.getUserInfo(getUserInfoDto));
    }
}
