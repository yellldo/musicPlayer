package com.music.player.framework.common.enmus;

import com.music.player.framework.common.core.StringArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * ClassName : UserTypeEnum<br>
 * Description : 全局用户类型枚举<br>
 *
 * @author : sj
 * @date : 2024/3/31
 */
@AllArgsConstructor
@Getter
public enum UserTypeEnum implements StringArrayValuable {

    MEMBER("1", "会员"), // 面向 c 端，普通用户
    ADMIN("2", "管理员"); // 面向 b 端，管理后台

    public static final String[] ARRAYS = (String[]) Arrays.stream(values()).map(UserTypeEnum::getValue).toArray();

    /**
     * 类型
     */
    private final String value;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public String[] array() {
        return ARRAYS;
    }
}
