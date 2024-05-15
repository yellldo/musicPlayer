package com.music.player.framework.uid;

import com.music.player.framework.uid.exception.UidGenerateException;

/**
 * ClassName : UidGenerator<br>
 * Description : Represents a unique id generator.<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public interface UidGenerator {

    /**
     * Get a unique ID
     *
     * @return UID
     * @throws UidGenerateException uid异常
     */
    long getUid() throws UidGenerateException;

    /**
     * Parse the UID into elements which are used to generate the UID. <br> Such as timestamp & workerId & sequence...
     *
     * @param uid uid
     * @return Parsed info
     */
    String parseUid(long uid);
}
