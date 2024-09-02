package com.music.player.infra.api.enmus;

import com.music.player.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * ClassName : UserTypeEnums<br>
 * Description : 用户类型枚举<br>
 *
 * @author : sj
 * @date : 2024/8/31
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnums implements IntArrayValuable {

    MEMBER(1, "会员"), // 面向 c 端，普通用户
    ADMIN(2, "管理员");// 面向 b 端，管理后台

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(UserTypeEnums::getValue).toArray();

    private final int value;

    private final String name;


    @Override
    public int[] array() {
        return ARRAYS;
    }
}
