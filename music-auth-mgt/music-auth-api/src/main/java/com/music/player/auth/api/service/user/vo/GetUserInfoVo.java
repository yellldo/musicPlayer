package com.music.player.auth.api.service.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : GetUserInfoVo<br>
 * Description : GetUserInfoVo<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
public class GetUserInfoVo implements Serializable {


    private String userName;

    private String loginType;

    private String phone;

    private String email;

    private String userStatus;

    private String isVip;
}
