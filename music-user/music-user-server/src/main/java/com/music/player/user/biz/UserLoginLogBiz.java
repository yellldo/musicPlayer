package com.music.player.user.biz;


import com.music.player.user.convert.UserLoginLogConvert;
import com.music.player.user.dto.CreateUserLoginLogDto;
import com.music.player.user.service.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName : UserLoginLogBiz<br>
 * Description : UserLoginLogBiz<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Component
public class UserLoginLogBiz {

    @Autowired
    private UserLoginLogService userLoginLogService;

    /**
     * 用户登录记录
     *
     * @param createUserLoginLogDto
     */
    public void recordLoginLog(CreateUserLoginLogDto createUserLoginLogDto) {
        userLoginLogService.save(UserLoginLogConvert.INSTANT.record(createUserLoginLogDto));
    }

}
