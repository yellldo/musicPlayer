package com.music.player.user.event;


import com.music.player.user.biz.UserLoginLogBiz;
import com.music.player.user.dto.CreateUserLoginLogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * ClassName : UserLoginLogListener<br>
 * Description : 用户登录日志监听<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class UserLoginLogListener {


    @Autowired
    private UserLoginLogBiz userLoginLogBiz;

    @Async
    @EventListener(UserLoginLogEvent.class)
    public void saveUserLoginLog(UserLoginLogEvent event) {
        try {
            CreateUserLoginLogDto createUserLoginLogDto = event.getCreateUserLoginLogDto();
            userLoginLogBiz.recordLoginLog(createUserLoginLogDto);
        } catch (Exception e) {
            log.error("记录登陆记录失败", e);
        }
    }


}
