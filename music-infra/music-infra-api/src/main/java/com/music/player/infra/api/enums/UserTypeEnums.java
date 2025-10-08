package com.music.player.infra.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * ClassName : UserTypeEnums<br>
 * Description : 用户类型枚举<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnums {

    MEMBER(1, "会员"), // 面向 c 端，普通用户
    ADMIN(2, "管理员");// 面向 b 端，管理后台

    private final int value;

    private final String name;

}
