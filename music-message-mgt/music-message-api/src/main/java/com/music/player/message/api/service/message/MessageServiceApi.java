package com.music.player.message.api.service.message;

import com.music.player.message.api.enums.ApiConstants;
import com.music.player.message.api.service.message.dto.CreateMessageDto;
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
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface MessageServiceApi {

    String PREFIX = "message/";

    /**
     * send message
     */
    @PostMapping(PREFIX + "createMessage")
    void createMessage(@RequestBody CreateMessageDto createMessageDto);

}
