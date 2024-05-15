package com.music.player.framework.mybatis.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * ClassName : PageDTO<br>
 * Description : 分页入参<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Data
public class PageDTO {

    @Min(1)
    private Integer pageNum;

    @Max(value = 2000)
    private Integer pageSize;
}
