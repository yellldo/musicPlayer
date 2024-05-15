package com.music.player.framework.uid.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ClassName : PaddedAtomicLong<br>
 * Description : Represents a padded {@link AtomicLong} to prevent the FalseSharing problem
 * <p>
 * The CPU cache line commonly be 64 bytes, here is a sample of cache line after padding:<br> 64 bytes = 8 bytes (object reference) + 6 * 8
 * bytes (padded long) + 8 bytes (a long value)<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
public class PaddedAtomicLong extends AtomicLong {

    private static final long serialVersionUID = -3415778863941386253L;

    /**
     * Padded 6 long (48 bytes)
     */
    private volatile long p1, p2, p3, p4, p5, p6 = 7L;

    /**
     * Constructors from {@link AtomicLong}
     */
    public PaddedAtomicLong() {
        super();
    }

    public PaddedAtomicLong(long initialValue) {
        super(initialValue);
    }

    /**
     * To prevent GC optimizations for cleaning unused padded references
     */
    public long sumPaddingToPreventOptimization() {
        return p1 + p2 + p3 + p4 + p5 + p6;
    }
}
