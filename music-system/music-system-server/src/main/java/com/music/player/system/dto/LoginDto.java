package com.music.player.system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : LoginDto<br>
 * Description : LoginDto<br>
 *
 * @author : sj
 * @date : 10/14/25
 */
@Setter
@Getter
@ToString
public class LoginDto implements Serializable {


    private String userName;

    private String password;
}
