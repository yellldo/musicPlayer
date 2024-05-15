package com.music.player.framework.uid.buffer;

/**
 * ClassName : RejectedPutBufferHandler<br>
 * Description : If tail catches the cursor it means that the ring buffer is full, any more buffer put request will be rejected. Specify the policy to
 * handle the reject. This is a Lambda supported interface<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@FunctionalInterface
public interface RejectedPutBufferHandler {

    /**
     * Reject put buffer request
     *
     * @param ringBuffer
     * @param uid
     */
    void rejectPutBuffer(RingBuffer ringBuffer, long uid);
}
