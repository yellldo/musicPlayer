package com.music.player.content.enmus;

import com.music.player.framework.common.exception.IErrorCode;

/**
 * ClassName : ErrorCodeConstants<br>
 * Description : ErrorCodeConstants<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
public enum ErrorCodeConstants implements IErrorCode {


    ARTISTS_AUDIT_DONE(1_004_000_001, "本条数据已审核完成"),
    ARTISTS_AUDIT_EXISTS(1_004_000_002, "已存在待审核的请求，请稍后再试或撤销当前申请。"),

    PLAYLIST_AUDIT_DONE(1_004_000_003, "本条歌单审核已完成"),
    PLAYLIST_AUDIT_NOT_FOUND(1_004_000_004, "歌单审核记录不存在"),

    ADVERTISE_NOT_FOUND(1_005_000_001, "广告不存在"),
    ACTIVITY_NOT_FOUND(1_005_000_002, "活动不存在"),
    GENRE_NOT_FOUND(1_005_000_003, "音乐类型不存在"),
    ;

    private final Integer code;
    private final String msg;


    ErrorCodeConstants(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.msg;
    }
}
