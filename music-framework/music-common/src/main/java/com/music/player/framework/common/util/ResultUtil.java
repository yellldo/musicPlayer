package com.music.player.framework.common.util;

import com.music.player.framework.common.base.HttpCode;
import com.music.player.framework.common.base.R;
import org.springframework.beans.BeanUtils;

public class ResultUtil {

    /**
     * 校验返回结果
     *
     * @param r
     * @return
     */
    public static Boolean checkResult(R r) {
        if (HttpCode.SUCCESS.getCode() == r.getCode()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 获取返回数据
     *
     * @param r
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getData(R r, T t) {
        Object data = r.getData();
        BeanUtils.copyProperties(data, t);
        return t;
    }
}
