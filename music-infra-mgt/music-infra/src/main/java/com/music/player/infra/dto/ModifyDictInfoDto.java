package com.music.player.infra.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : ModifyDictInfoDto<br>
 * Description : ModifyDictInfoDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ToString
@ApiModel("更新字典实体")
public class ModifyDictInfoDto {

    @ApiModelProperty("字典di")
    private Integer id;

    @ApiModelProperty("字典值")
    private String dictValue;

    @ApiModelProperty("字典描述")
    private String dictRemark;

    @ApiModelProperty("字典状态")
    private String dictStatus;
}
