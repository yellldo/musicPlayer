package com.music.player.auth.api.service.user;

import com.music.player.auth.api.enums.ApiConstants;
import com.music.player.auth.api.service.user.dto.GetSysUserInfoDto;
import com.music.player.auth.api.service.user.vo.SysUserInfoVo;
import com.music.player.framework.common.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * ClassName : SysUserServiceApi<br>
 * Description : SysUserServiceApi<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
@FeignClient(value = ApiConstants.NAME, path = ApiConstants.PATH)
public interface SysUserServiceApi {


    String PREFIX = "/sysUser/";

    @PostMapping(PREFIX + "getSysUserInfo")
    R<SysUserInfoVo> getSysUserInfo(@RequestBody GetSysUserInfoDto getSysUserInfoDto);


}
