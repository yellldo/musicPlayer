package com.music.player.message.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class MessageSenderDto implements Serializable {

    private Long messageId;

    private String messageType;

    private String messageTitle;

    private String messageContent;

    private String messageReceiver;

    private Integer retryCount;
}
