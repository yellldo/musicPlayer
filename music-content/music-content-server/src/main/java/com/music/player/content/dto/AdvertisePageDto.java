package com.music.player.content.dto;

import com.music.player.framework.common.base.QueryRequestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName : AdvertisePageDto<br>
 * Description : 广告分页查询参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
public class AdvertisePageDto extends QueryRequestParam {

    private String title;

    private String type;

    private String status;
}
