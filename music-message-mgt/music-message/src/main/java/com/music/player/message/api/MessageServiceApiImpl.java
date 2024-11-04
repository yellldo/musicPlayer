package com.music.player.message.api;

import com.music.player.message.api.dto.CreateMessageDto;
import com.music.player.message.api.service.MessageServiceApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : MessageServiceApiImpl<br>
 * Description : MessageServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/10/26
 */
@RestController
public class MessageServiceApiImpl implements MessageServiceApi {


    @Override
    public void createMessage(CreateMessageDto createMessageDto) {

    }
}
