package com.music.player.infra.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * ClassName : SaveDictInfoDto<br>
 * Description : SaveDictInfoDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@ApiModel("新增字典实体")
@Setter
@Getter
@ToString
public class SaveDictInfoDto implements Serializable {

    @NotEmpty(message = "请输入字典类型")
    @ApiModelProperty("字典类型")
    private String dictType;

    @NotEmpty(message = "请输入字典key")
    @ApiModelProperty("字典key")
    private String dictKey;

    @ApiModelProperty("父级id")
    private Integer parentId;

    @NotEmpty(message = "请输入字典值")
    @ApiModelProperty("字典值")
    private String dictValue;

    @ApiModelProperty("字典描述")
    private String dictRemark;

}
