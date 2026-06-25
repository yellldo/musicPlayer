package com.music.player.content.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : AdvertiseCreateDto<br>
 * Description : 广告新增参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AdvertiseCreateDto implements Serializable {

    @NotBlank(message = "广告标题不能为空")
    private String title;

    @NotBlank(message = "广告类型不能为空")
    private String type;

    private String imageUrl;

    private String linkUrl;

    private String position;

    private Integer sortOrder;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    private String status;

    private String remark;
}
