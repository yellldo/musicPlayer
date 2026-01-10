package com.music.player.framework.common.constants;

/**
 * ClassName : CommonConstants<br>
 * Description : CommonConstants<br>
 *
 * @author : sj
 * @date : 8/31/25
 */
public class CommonConstants {

    /**
     * 删除
     */
    public static final String STATUS_DEL = "1";
    /**
     * 未删除
     */
    public static final String STATUS_NOT_DEL = "0";

    public static final Integer PWD_ERROR_COUNT = 0;

    public static final Integer PWD_MAX_ERROR_COUNT = 9;


    public static final String USER_STATUS_NORMAL = "0";

    public static final String USER_STATUS_DISABLED = "1";

    /**
     * 锁定
     */
    public static final String USER_STATUS_LOCKED = "-1";

    /**
     * 需要重置
     */
    public static final String STATUS_RESET = "1";
    /**
     * 不需要重置
     */
    public static final String STATUS_NOT_RESET = "0";

    /**
     * 菜单树根节点
     */
    public static final Long MENU_TREE_ROOT_ID = -1L;

    /**
     * 菜单
     */
    public static final String MENU = "0";

    /**
     * 编码
     */
    public static final String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";


    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    public static final String AUTHORIZATION = "Authorization";

    public static final String ADM_USER_ID = "adm-userId";

    /**
     * 请求开始时间
     */
    public static final String REQUEST_START_TIME = "REQUEST-START-TIME";
}
