package com.music.player.message.consumers;

import com.music.player.message.constant.MessageStatusConstant;
import com.music.player.message.constant.RocketMqTopicConstant;
import com.music.player.message.dto.MessageSenderDto;
import com.music.player.message.entity.MessageInfo;
import com.music.player.message.sender.factory.SenderFactory;
import com.music.player.message.service.MessageInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RocketMQMessageListener(topic = RocketMqTopicConstant.TOPIC_MESSAGE_COMMON, consumerGroup = RocketMqTopicConstant.GROUP_COMMON)
public class MessageCommonConsumers implements RocketMQListener<MessageSenderDto> {

    @Autowired
    private SenderFactory senderFactory;
    @Autowired
    private MessageInfoService messageInfoService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void onMessage(MessageSenderDto messageSenderDto) {
        String messageType = messageSenderDto.getMessageType();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageId(messageSenderDto.getMessageId());
        try {
            senderFactory.getSender(messageType).send(messageSenderDto);
            messageInfo.setMessageStatus(MessageStatusConstant.MESSAGE_STATUS_SUCCESS);
        } catch (Exception e) {
            log.error("发送邮件失败", e);
            messageInfo.setRetryCount(messageSenderDto.getRetryCount() + 1);
            messageInfo.setMessageStatus(MessageStatusConstant.MESSAGE_STATUS_FAILED);
        }
        messageInfoService.updateById(messageInfo);
        // if retry count <= 5,will by resend
        if (messageInfo.getRetryCount() <= 5) {
            rocketMQTemplate.convertAndSend(RocketMqTopicConstant.TOPIC_MESSAGE_COMMON, messageSenderDto);
        }
    }
}
