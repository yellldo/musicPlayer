package com.music.player.content.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName : GenreCreateDto<br>
 * Description : 音乐类型新增参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class GenreCreateDto implements Serializable {

    @NotBlank(message = "类型名称不能为空")
    private String name;

    private String description;

    private Integer sortOrder;

    private String status;

    private String remark;
}
