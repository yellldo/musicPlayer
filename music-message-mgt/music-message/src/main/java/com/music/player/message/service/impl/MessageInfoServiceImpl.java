package com.music.player.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.player.message.entity.MessageInfo;
import com.music.player.message.mapper.MessageInfoMapper;
import com.music.player.message.service.MessageInfoService;
import org.springframework.stereotype.Service;

@Service
public class MessageInfoServiceImpl extends ServiceImpl<MessageInfoMapper, MessageInfo> implements MessageInfoService {
}
