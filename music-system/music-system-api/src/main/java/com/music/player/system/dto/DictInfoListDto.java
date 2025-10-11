package com.music.player.system.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * ClassName : DictInfoListDto<br>
 * Description : DictInfoListDto<br>
 *
 * @author : sj
 * @date : 2025/10/11
 */
@Setter
@Getter
@ToString
public class DictInfoListDto {

    @NotBlank(message = "参数异常")
    private String dictType;
}
