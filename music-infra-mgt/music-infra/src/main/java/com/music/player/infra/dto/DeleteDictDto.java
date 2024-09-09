package com.music.player.infra.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : DeleteDictDto<br>
 * Description : DeleteDictDto<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Setter
@Getter
@ToString
@ApiModel("删除字典实体")
public class DeleteDictDto {

    private Integer id;

}
