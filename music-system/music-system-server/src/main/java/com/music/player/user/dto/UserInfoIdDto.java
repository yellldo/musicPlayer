package com.music.player.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : UserInfoIdDto<br>
 * Description : UserInfoIdDto<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class UserInfoIdDto {

    @NotNull(message = "参数异常")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
}
