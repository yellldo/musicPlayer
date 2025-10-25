package com.music.player.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@Accessors(chain = true)
@NoArgsConstructor
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = -6495567086389149352L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String loginName;

    private String nickName;

    private String userStatus;

    private String remark;

    private String phone;

    private String email;

    private String createTime;

    private List<String> roleList;

}
