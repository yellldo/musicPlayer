package com.music.player.message.rest;

import com.music.player.message.api.dto.CreateMessageDto;
import com.music.player.message.api.service.MessageServiceFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : MessageCtrl<br>
 * Description : MessageCtrl<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */

@RestController
public class MessageCtrl implements MessageServiceFeign {


    @Override
    public void createMessage(CreateMessageDto createMessageDto) {

    }
}
