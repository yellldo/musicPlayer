package com.music.player.infra.api;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.service.file.InfraFileServiceApi;
import com.music.player.infra.api.service.file.dto.UploadFileDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName : InfraFileServiceApiImpl<br>
 * Description : InfraFileServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/9/25
 */
@RestController
public class InfraFileServiceApiImpl implements InfraFileServiceApi {


    @Override
    public R uploadFile(UploadFileDto uploadFileDto) {
        MultipartFile multipartFile = uploadFileDto.getMultipartFile();
        String fileName = multipartFile.getName();


        return null;
    }
}
