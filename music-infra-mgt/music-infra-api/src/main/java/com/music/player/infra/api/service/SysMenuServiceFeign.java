package com.music.player.infra.api.service;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.dto.QuerySysMenuDto;
import com.music.player.infra.api.enmus.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName : SysMenuServiceFeign<br>
 * Description : SysMenuServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/5/23
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-infra")
public interface SysMenuServiceFeign {

    @PostMapping("menu/querySysMenu")
    R querySysMenu(@RequestBody QuerySysMenuDto querySysMenuDto);
}
