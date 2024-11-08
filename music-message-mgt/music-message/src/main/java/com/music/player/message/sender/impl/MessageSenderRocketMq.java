package com.music.player.message.sender.impl;

import com.music.player.message.constant.RocketMqTopicConstant;
import com.music.player.message.dto.MessageSenderDto;
import com.music.player.message.sender.MessageSender;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MessageSenderRocketMq implements MessageSender {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(MessageSenderDto messageSenderDto) {
        rocketMQTemplate.convertAndSend(RocketMqTopicConstant.TOPIC_MESSAGE_COMMON, messageSenderDto);
    }
}
