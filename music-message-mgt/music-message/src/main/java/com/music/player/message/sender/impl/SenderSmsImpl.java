package com.music.player.message.sender.impl;

import com.music.player.message.constant.SenderConstant;
import com.music.player.message.dto.MessageSenderDto;
import com.music.player.message.sender.Sender;
import org.springframework.stereotype.Repository;

@Repository
public class SenderSmsImpl implements Sender {


    @Override
    public String type() {
        return SenderConstant.MESSAGE_TYPE_SMS;
    }

    @Override
    public void send(MessageSenderDto messageSenderDto) {

    }
}
