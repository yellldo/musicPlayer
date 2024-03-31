package com.music.player.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.auth.api.domain.UserDetails;
import com.music.player.auth.entity.UserInfo;
import org.springframework.cache.annotation.Cacheable;

/**
 * ClassName : UserInfoService<br>
 * Description : UserInfoService<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
public interface UserInfoService extends IService<UserInfo> {

    @Cacheable(cacheNames = "web:user:phone", key = "#phone")
    public UserDetails loadUserByPhone(String phone);

    @Cacheable(cacheNames = "web:user:email", key = "#email")
    public UserDetails loadUserByEmail(String email);


}
