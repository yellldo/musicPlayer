package com.music.player.infra.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ClassName : CommonUploadFileDto<br>
 * Description : CommonUploadFileDto<br>
 *
 * @author : sj
 * @date : 2024/9/25
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class CommonUploadFileDto {

    private String fileName;


}
