package org.labs.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;

@Slf4j
public class TaskScheduler {

    private Timer timer;

    public TaskScheduler() {
        this.timer = new Timer(true);
    }

    public void scheduleTask(TaskExecutor taskExecutor, int millis) {
        timer.scheduleAtFixedRate(taskExecutor, 0,  millis);
    }

    public void finish() {
        this.timer.cancel();
        log.info("<<<< Вот и конец!");
    }
}
