package com.music.player.infra.api.service.dict;

import com.music.player.infra.api.enmus.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName : SysDictServiceApi<br>
 * Description : SysDictServiceApi<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface SysDictServiceApi {


}
