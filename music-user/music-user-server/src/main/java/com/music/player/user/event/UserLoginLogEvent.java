package com.music.player.user.event;


import com.music.player.user.dto.CreateUserLoginLogDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * ClassName : UserLoginLogEvent<br>
 * Description : UserLoginLogEvent<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
public class UserLoginLogEvent extends ApplicationEvent {

    private CreateUserLoginLogDto createUserLoginLogDto;

    public UserLoginLogEvent(CreateUserLoginLogDto createUserLoginLogDto) {
        super(createUserLoginLogDto);
        this.createUserLoginLogDto = createUserLoginLogDto;
    }
}
