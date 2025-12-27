package com.music.player.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.user.entity.UserMessage;
import com.music.player.user.mapper.UserMessageMapper;
import com.music.player.user.service.UserMessageService;
import org.springframework.stereotype.Service;

/**
 * ClassName : UserMessageServiceImpl<br>
 * Description : UserMessageServiceImpl<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@Service
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {
}
