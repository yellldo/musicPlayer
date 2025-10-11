package com.music.player.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : LoginVo<br>
 * Description : LoginVo<br>
 *
 * @author : sj
 * @date : 10/10/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class LoginVo {

    private String token;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long tokenTimeout;
}
