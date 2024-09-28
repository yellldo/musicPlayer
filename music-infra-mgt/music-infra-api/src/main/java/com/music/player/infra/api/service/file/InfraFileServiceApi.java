package com.music.player.infra.api.service.file;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.enmus.ApiConstants;
import com.music.player.infra.api.service.file.dto.UploadFileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : InfraFileServiceApi<br>
 * Description : InfraFileServiceApi<br>
 *
 * @author : sj
 * @date : 2024/9/25
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface InfraFileServiceApi {

    public final static String PREFIX = "/infraFile/";

    @PostMapping(PREFIX + "uploadFile")
    R uploadFile(@RequestBody UploadFileDto uploadFileDto);
}
