package com.music.player.auth.api.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName : SysUserServiceFeign<br>
 * Description : SysUserServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient("music-auth")
public interface SysUserServiceFeign {


}
