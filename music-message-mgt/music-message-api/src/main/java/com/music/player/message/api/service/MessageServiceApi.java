package com.music.player.message.api.service;

import com.music.player.message.api.dto.CreateMessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : MessageServiceApi<br>
 * Description : MessageServiceApi<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@FeignClient(value = "music-message")
public interface MessageServiceApi {

    /**
     * 发送消息
     *
     * @param createMessageDto
     */
    @PostMapping("createMessage")
    public void createMessage(@RequestBody CreateMessageDto createMessageDto);

}
