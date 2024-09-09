package com.baidu.fsg.uid.buffer;

import java.util.List;

/**
 * ClassName : BufferedUidProvider<br>
 * Description : Buffered UID provider(Lambda supported), which provides UID in the same one second<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@FunctionalInterface
public interface BufferedUidProvider {


    /**
     * Provides UID in one second
     *
     * @param momentInSecond
     * @return
     */
    List<Long> provide(long momentInSecond);
}
