package com.music.player.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName : DictCodeVo<br>
 * Description : DictCodeVo<br>
 *
 * @author : sj
 * @date : 10/18/25
 */
@Setter
@Getter
@ToString
public class DictCodeVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String dictType;

    private String dictCode;

    private String dictName;

    private Integer dictStatus;

    private Integer sort;

    private String dictRemark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
