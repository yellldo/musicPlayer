package com.music.player.system.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : DictInfoVo<br>
 * Description : DictInfoVo<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Setter
@Getter
@ToString
public class DictInfoVo {

    private Long id;

    private String dictType;

    private String dictKey;

    private String dictValue;

    private String dictRemark;

    private LocalDateTime createTime;

    private String createBy;
}
