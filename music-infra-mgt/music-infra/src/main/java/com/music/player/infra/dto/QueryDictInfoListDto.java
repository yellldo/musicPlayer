package com.music.player.infra.dto;

import com.music.player.framework.common.base.QueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : QueryDictInfoListDto<br>
 * Description : QueryDictInfoListDto<br>
 *
 * @author : sj
 * @date : 2024/9/6
 */
@Setter
@Getter
@ToString(callSuper = true)
@ApiModel("查询字典列表实体")
public class QueryDictInfoListDto extends QueryRequest implements Serializable {

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("字典key")
    private String dictKey;

    @ApiModelProperty("字典状态")
    private String dictStatus;
}


