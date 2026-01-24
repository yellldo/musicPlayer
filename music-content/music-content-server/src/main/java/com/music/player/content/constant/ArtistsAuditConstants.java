package com.music.player.content.constant;

/**
 * ClassName : ArtistsAuditConstants<br>
 * Description : ArtistsAuditConstants<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
public class ArtistsAuditConstants {

    /**
     * 审核状态: 1-待审核, 2-审核通过, 3-审核驳回, 4-已撤销
     */
    public static final String ARTISTS_AUDITS_STATUS_INIT = "1";

    public static final String ARTISTS_AUDITS_STATUS_PASS = "2";
    public static final String ARTISTS_AUDITS_STATUS_REJECT = "3";
    public static final String ARTISTS_AUDITS_STATUS_CANCEL = "4";

    public static final String ARTISTS_TYPE_CREATE = "1";
    public static final String ARTISTS_TYPE_UPDATE = "2";
}
