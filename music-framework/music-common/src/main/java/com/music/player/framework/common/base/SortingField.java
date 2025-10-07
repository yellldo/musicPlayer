package com.music.player.framework.common.base;

import lombok.*;

/**
 * ClassName : SortingField<br>
 * Description : SortingField<br>
 *
 * @author : sj
 * @date : 10/7/25
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SortingField {

    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";
    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;
}
