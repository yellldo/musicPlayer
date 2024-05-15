package com.music.player.framework.uid.worker;

/**
 * ClassName : WorkerIdAssigner<br>
 * Description : Represents a worker id assigner for {@link com.music.player.framework.uid.impl.DefaultUidGenerator}<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public interface WorkerIdAssigner {

    /**
     * Assign worker id for {@link com.music.player.framework.uid.impl.DefaultUidGenerator}
     *
     * @return assigned worker id
     */
    long assignWorkerId();
}
