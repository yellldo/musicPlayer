package com.music.player.message.sender;

import com.music.player.message.dto.MessageSenderDto;

public interface Sender {

    String type();

    public void send(MessageSenderDto messageSenderDto);
}
