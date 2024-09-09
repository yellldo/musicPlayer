package com.music.player.auth.api.service.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : UserInfoVo<br>
 * Description : UserInfoVo<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
public class UserInfoVo implements Serializable {


    private String userName;

    private String loginType;

    private String phone;

    private String email;

    private String userStatus;

    private String isVip;
}
