package com.music.player.adm.dto;

import com.music.player.framework.common.base.QueryRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryMenuListDto<br>
 * Description : QueryMenuListDto<br>
 *
 * @author : sj
 * @date : 2024/9/17
 */
@Setter
@Getter
@ToString
public class QueryMenuListDto extends QueryRequest implements Serializable {


    private String menuName;

    private String menuType;

}
