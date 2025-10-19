package com.music.player.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * ClassName : DictDetailVo<br>
 * Description : DictDetailVo<br>
 *
 * @author : sj
 * @date : 10/19/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class DictDetailVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String dictLabel;

    private String dictValue;

    private Integer dictStatus;

    private Integer sort;

    private String dictRemark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
