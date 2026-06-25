package com.music.player.content.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : GenrePageDto<br>
 * Description : 音乐类型分页查询参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
public class GenrePageDto extends QueryRequestParam {

    private String name;

    private String status;
}
