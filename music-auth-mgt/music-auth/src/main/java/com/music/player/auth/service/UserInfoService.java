package com.music.player.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.music.player.auth.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ClassName : UserInfoService<br>
 * Description : UserInfoService<br>
 *
 * @author : sj
 * @date : 2024/3/21
 */
public interface UserInfoService extends IService<UserInfo> {

    public UserDetails loadUserByPhone(String phone);

    public UserDetails loadUserByEmail(String email);


}
