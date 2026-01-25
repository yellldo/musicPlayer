package com.music.player.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String dictType;

    private String dictKey;

    private String dictLabel;

    private Integer sort;

    private String dictValue;

    private String dictRemark;

    private Integer dictStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String createBy;
}
