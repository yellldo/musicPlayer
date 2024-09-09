package com.music.player.auth.api;

import com.music.player.auth.api.service.user.SysUserServiceApi;
import com.music.player.auth.api.service.user.dto.GetSysUserInfoDto;
import com.music.player.auth.api.service.user.vo.SysUserInfoVo;
import com.music.player.auth.constants.AuthRedisKey;
import com.music.player.auth.utils.JwtTokenUtil;
import com.music.player.framework.cache.service.CacheService;
import com.music.player.framework.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName : SysUserServiceApiImpl<br>
 * Description : SysUserServiceApiImpl<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@RestController
public class SysUserServiceApiImpl implements SysUserServiceApi {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public R<SysUserInfoVo> getSysUserInfo(GetSysUserInfoDto getSysUserInfoDto) {
        String key = AuthRedisKey.SYS_USER_KEY + getSysUserInfoDto.getToken();
        if (cacheService.exists(key)) {
            return R.ok(cacheService.get(key));
        }
        return null;
    }
}
