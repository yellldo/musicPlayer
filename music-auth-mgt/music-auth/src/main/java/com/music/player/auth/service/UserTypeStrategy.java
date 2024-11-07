package com.music.player.auth.service;


import com.music.player.auth.bo.UserTypeBaseBo;


/**
 * ClassName : UserTypeStrategy<br>
 * Description : Gets the user information policy interface based on the user type.<br>
 *
 * @author : sj
 * @date : 2024/11/7
 */
public interface UserTypeStrategy {

    String userType();

    UserTypeBaseBo getUserInfo(Long userId);


}
