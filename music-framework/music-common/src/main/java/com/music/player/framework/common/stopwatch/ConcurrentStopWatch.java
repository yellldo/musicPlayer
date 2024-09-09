package com.music.player.framework.common.stopwatch;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName : ConcurrentStopWatch<br>
 * Description : ConcurrentStopWatch<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
@Slf4j
public class ConcurrentStopWatch {

    private ThreadLocal<StopWatch> stopWatchThreadLocal;


    public ConcurrentStopWatch() {
        this.stopWatchThreadLocal = ThreadLocal.withInitial(StopWatch::new);
    }


    public ConcurrentStopWatch(final String name) {
        this.stopWatchThreadLocal = ThreadLocal.withInitial(() -> new StopWatch(name));
    }

    public void start(String taskName) {
        try {
            if (!this.stopWatchThreadLocal.get().isRunning()) {
                this.stopWatchThreadLocal.get().start(taskName);
            } else {
                this.stopWatchThreadLocal.get().stop();
            }
        } catch (Exception e) {
            log.error("开始监控任务{}失败，原因：", taskName, e.getCause());
        }
    }

    public void stop() {
        try {
            if (this.stopWatchThreadLocal.get().isRunning()) {
                this.stopWatchThreadLocal.get().stop();
            }
        } catch (Exception e) {
            log.error("停止监控任务失败，原因：", e.getCause());
        }
    }

    /**
     * 获取任务执行毫秒数
     *
     * @return
     */
    public long totalTimeMillis() {
        try {
            return this.stopWatchThreadLocal.get().getTotalTimeMillis();
        } catch (Exception e) {
            log.error("获取任务执行毫秒数失败，原因：", e.getCause());
        }
        return 0;
    }

    public String prettyPrint() {
        try {
            return this.stopWatchThreadLocal.get().prettyPrint();
        } catch (Exception e) {
            log.error("打印监控日志失败，原因", e.getCause());
        }
        return "";
    }

}
