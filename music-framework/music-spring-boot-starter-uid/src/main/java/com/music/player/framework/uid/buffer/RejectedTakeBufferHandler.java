package com.music.player.framework.uid.buffer;

/**
 * ClassName : RejectedTakeBufferHandler<br>
 * Description :
 * If cursor catches the tail it means that the ring buffer is empty, any more buffer take request will be rejected. Specify the policy to
 * handle the reject. This is a Lambda supported interface<br>
 *
 * @author : sj
 * @date : 2024/5/1
 */
@FunctionalInterface
public interface RejectedTakeBufferHandler {

    /**
     * Reject take buffer request
     *
     * @param ringBuffer
     */
    void rejectTakeBuffer(RingBuffer ringBuffer);
}
