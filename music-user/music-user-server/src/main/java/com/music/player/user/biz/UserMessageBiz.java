package com.music.player.user.biz;

import com.music.player.user.dto.CreateUserMessageDto;
import com.music.player.user.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName : UserMessageBiz<br>
 * Description : UserMessageBiz<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@Component
public class UserMessageBiz {

    @Autowired
    private UserMessageService userMessageService;

    public void createMessage(CreateUserMessageDto createUserMessageDto) {


    }
}
