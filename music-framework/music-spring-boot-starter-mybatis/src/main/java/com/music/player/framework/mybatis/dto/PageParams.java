package com.music.player.framework.mybatis.dto;

import com.music.player.framework.mybatis.constant.EntityConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName : PageParams<br>
 * Description : 分页参数<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageParams<T> extends PageDTO {

    /**
     * 查询参数
     */
    private T model;

    /**
     * 排序,默认createTime，可以使用id,createTime,updateTime，默认为id
     */
    private String sort = EntityConstant.ID;

    /**
     * 扩展参数
     */
    private Map<String, String> extra = new HashMap<>(16);
}
