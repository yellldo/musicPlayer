package com.music.player.adm.dto;

import com.music.player.framework.common.base.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("查询用户实体")
public class QuerySysUserListDto extends QueryRequest implements Serializable {

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 用户状态
     */
    @ApiModelProperty("用户状态")
    private String userStatus;
}
