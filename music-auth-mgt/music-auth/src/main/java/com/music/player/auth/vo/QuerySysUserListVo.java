package com.music.player.auth.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * ClassName : QuerySysUserListVo<br>
 * Description : QuerySysUserListVo<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
public class QuerySysUserListVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String nickName;

    private String userStatus;

    private String isDelete;

    private Date createTime;
}

