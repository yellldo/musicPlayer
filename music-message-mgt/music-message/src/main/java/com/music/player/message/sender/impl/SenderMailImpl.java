package com.music.player.message.sender.impl;

import com.music.player.message.config.MailConfig;
import com.music.player.message.constant.SenderConstant;
import com.music.player.message.dto.MessageSenderDto;
import com.music.player.message.sender.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class SenderMailImpl implements Sender {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailConfig mailConfig;

    @Override
    public String type() {
        return SenderConstant.MESSAGE_TYPE_MAIL;
    }

    @Override
    public void send(MessageSenderDto messageSenderDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText(messageSenderDto.getMessageContent());
        simpleMailMessage.setTo(messageSenderDto.getMessageReceiver());
        simpleMailMessage.setSubject(messageSenderDto.getMessageTitle());
        simpleMailMessage.setFrom(mailConfig.getUserName());
        javaMailSender.send(simpleMailMessage);
        log.info("邮件发送成功");
    }

}
