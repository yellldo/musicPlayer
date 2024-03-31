package com.music.player.framework.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * ClassName : SortablePageParam<br>
 * Description : SortablePageParam<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@Schema(description = "可排序的分页参数")
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SortablePageParam extends PageParam {


    @Schema(description = "排序字段")
    private List<SortingField> sortingFields;
}
