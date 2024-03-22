package com.music.player.auth.biz;

import com.music.player.auth.api.dto.UserLoginDto;
import com.music.player.auth.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserBiz<br>
 * Description : UserBiz<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@Service
public class UserBiz {

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 登录
     */
    public void login(UserLoginDto userLoginDto) {


    }

}
