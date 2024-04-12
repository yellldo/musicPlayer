package com.music.player.auth.api.service;

import com.music.player.auth.api.enums.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName : SysUserServiceFeign<br>
 * Description : SysUserServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-auth")
public interface SysUserServiceFeign {


}
