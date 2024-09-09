package com.baidu.fsg.uid.worker;

/**
 * ClassName : WorkerIdAssigner<br>
 * Description :
 * Represents a worker id assigner for {@link com.baidu.fsg.uid.impl.DefaultUidGenerator}<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface WorkerIdAssigner {

    /**
     * Assign worker id for {@link com.baidu.fsg.uid.impl.DefaultUidGenerator}
     *
     * @return assigned worker id
     */
    long assignWorkerId();

}
