package com.music.player.content.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName : AdvertiseUpdateDto<br>
 * Description : 广告编辑参数<br>
 *
 * @author : sj
 * @date : 6/23/26
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class AdvertiseUpdateDto implements Serializable {

    @NotNull(message = "广告ID不能为空")
    private Long id;

    private String title;

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
