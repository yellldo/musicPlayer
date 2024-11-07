package com.music.player.adm.dto;

import com.music.player.framework.common.base.QueryRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryRoleListDto<br>
 * Description : QueryRoleListDto<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@Setter
@Getter
@ToString
public class QueryRoleListDto extends QueryRequest implements Serializable {

    private String roleName;

    private String enable;
}
