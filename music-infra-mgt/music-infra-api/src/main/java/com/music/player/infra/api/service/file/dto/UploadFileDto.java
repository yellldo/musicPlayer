package com.music.player.infra.api.service.file.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName : UploadFileDto<br>
 * Description : UploadFileDto<br>
 *
 * @author : sj
 * @date : 2024/9/25
 */
@Setter
@Getter
@ToString
public class UploadFileDto {

    private String fileChannel;

    private MultipartFile multipartFile;

}
