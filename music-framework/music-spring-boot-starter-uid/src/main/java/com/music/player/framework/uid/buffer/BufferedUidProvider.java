package com.music.player.framework.uid.buffer;

import java.util.List;

/**
 * ClassName : BufferedUidProvider<br>
 * Description : Buffered UID provider(Lambda supported), which provides UID in the same one second<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@FunctionalInterface
public interface BufferedUidProvider {

    /**
     * Provides UID in one second
     *
     * @param momentInSecond momentInSecond
     * @return 1秒类提供的UID
     */
    List<Long> provide(long momentInSecond);
}
