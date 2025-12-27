package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.framework.common.constants.FeignConstants;
import com.music.player.user.dto.CreateUserMessageDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : UserMessageApi<br>
 * Description : UserMessageApi<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@FeignClient(value = FeignConstants.MUSIC_SYSTEM, path = FeignConstants.MUSIC_SYSTEM_URL)
public interface UserMessageApi {

    /**
     * 发送消息
     *
     * @param createUserMessageDto
     * @return
     */
    R<Void> sendMessage(@Valid @RequestBody CreateUserMessageDto createUserMessageDto);

}
