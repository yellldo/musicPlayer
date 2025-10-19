package com.music.player.system.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : LoginVo<br>
 * Description : LoginVo<br>
 *
 * @author : sj
 * @date : 10/14/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class LoginVo {

    private String isReset;

    private String token;
}
