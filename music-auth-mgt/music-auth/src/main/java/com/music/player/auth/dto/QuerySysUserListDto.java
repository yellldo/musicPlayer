package com.music.player.auth.dto;

import com.music.player.framework.common.base.QueryRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QuerySysUserListDto<br>
 * Description : QuerySysUserListDto<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Setter
@Getter
@ToString
public class QuerySysUserListDto extends QueryRequest implements Serializable {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户状态
     */
    private String userStatus;
}
