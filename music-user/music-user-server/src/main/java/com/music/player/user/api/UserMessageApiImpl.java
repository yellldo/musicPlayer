package com.music.player.user.api;

import com.music.player.framework.common.base.R;
import com.music.player.user.biz.UserMessageBiz;
import com.music.player.user.dto.CreateUserMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : UserMessageApiImpl<br>
 * Description : UserMessageApiImpl<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@RestController
public class UserMessageApiImpl implements UserMessageApi {

    @Autowired
    private UserMessageBiz userMessageBiz;


    @Override
    public R<Void> sendMessage(CreateUserMessageDto createUserMessageDto) {
        userMessageBiz.createMessage(createUserMessageDto);
        return R.ok();
    }
}
