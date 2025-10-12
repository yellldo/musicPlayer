package com.music.player.system.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : SysUserVo<br>
 * Description : SysUserVo<br>
 *
 * @author : sj
 * @date : 10/12/25
 */
@Setter
@Getter
@ToString
public class SysUserVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String loginName;

    private String userStatus;

    private String remark;

    private LocalDateTime createTime;
}
