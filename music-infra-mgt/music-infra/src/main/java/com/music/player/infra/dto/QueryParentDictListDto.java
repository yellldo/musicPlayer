package com.music.player.infra.dto;

import com.music.player.framework.common.base.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : QueryParentDictListDto<br>
 * Description : QueryParentDictListDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ApiModel("查询父级字典列表实体")
@ToString(callSuper = true)
public class QueryParentDictListDto extends QueryRequest {


    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("字典value")
    private String dictValue;
}
