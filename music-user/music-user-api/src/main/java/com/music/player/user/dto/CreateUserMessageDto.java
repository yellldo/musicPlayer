package com.music.player.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : CreateUserMessageDto<br>
 * Description : CreateUserMessageDto<br>
 *
 * @author : sj
 * @date : 12/21/25
 */
@Setter
@Getter
@ToString
public class CreateUserMessageDto implements Serializable {

    @NotNull(message = "发送人不能为空")
    private Long sendId;

    @NotNull(message = "接受人不能为空")
    private Long receiveId;

    @NotBlank(message = "消息标题不能为空")
    private String messageTitle;

    @NotBlank(message = "消息类型不能为空")
    private String messageType;

    @NotBlank(message = "消息内容不能为空")
    private String messageContent;
}
