package com.music.player.message.sender;

import com.music.player.message.dto.MessageSenderDto;

public interface MessageSender {


    /**
     * Send messages based on type
     */
    void send(MessageSenderDto messageSenderDto);
}
