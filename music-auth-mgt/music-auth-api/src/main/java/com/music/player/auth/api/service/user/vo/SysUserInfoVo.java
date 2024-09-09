package com.music.player.auth.api.service.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : SysUserInfoVo<br>
 * Description : SysUserInfoVo<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class SysUserInfoVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String loginName;

    private String nickName;

    private String userStatus;
}
