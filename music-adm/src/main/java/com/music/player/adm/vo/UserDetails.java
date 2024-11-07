package com.music.player.adm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : UserDetails<br>
 * Description : UserDetails<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UserDetails {

    private String loginName;

}
