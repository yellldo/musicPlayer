package com.music.player.content.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : GenreUpdateDto<br>
 * Description : 音乐类型编辑参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class GenreUpdateDto implements Serializable {

    @NotNull(message = "类型ID不能为空")
    private Long id;

    private String name;

    private String description;

    private Integer sortOrder;

    private String status;

    private String remark;
}
