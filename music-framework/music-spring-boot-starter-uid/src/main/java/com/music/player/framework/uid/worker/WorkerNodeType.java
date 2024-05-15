package com.music.player.framework.uid.worker;

import com.music.player.framework.uid.util.ValuedEnum;

/**
 * ClassName : WorkerNodeType<br>
 * Description : WorkerNodeType<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public enum WorkerNodeType implements ValuedEnum<Integer> {

    /**
     * 容器
     */
    CONTAINER(1),
    /**
     * 实际机器
     */
    ACTUAL(2);

    /**
     * Lock type
     */
    private final Integer type;

    /**
     * Constructor with field of type
     */
    WorkerNodeType(Integer type) {
        this.type = type;
    }

    @Override
    public Integer value() {
        return type;
    }
}
