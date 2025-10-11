package com.music.player.user.event;


import com.music.player.user.dto.CreateUserLoginLogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

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


    private final Consumer<Object> consumer;


    @Async
    @EventListener(UserLoginLogEvent.class)
    public void saveUserLoginLog(UserLoginLogEvent event) {
        CreateUserLoginLogDto createUserLoginLogDto = event.getCreateUserLoginLogDto();
        consumer.accept(createUserLoginLogDto);
    }


}
