package org.labs.task1;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;

import java.util.concurrent.TimeUnit;

/**
 * @author - Марчук Александр
 */
@Slf4j
public class Main1 {

    public static void main(String[] args) {
        var task1 = new TaskExecutor("Прошла ещё одна секунда", 1);
        var task2 = new TaskExecutor("Прошло пять секунд", 5);
        var taskScheduler = new TaskScheduler();

        taskScheduler.scheduleTask(task1, 1000);
        taskScheduler.scheduleTask(task2, 5000);
        try {
            val timeOfAction = 30;
            TimeUnit.SECONDS.sleep(timeOfAction);
        } catch (InterruptedException exc) {
           log.error("Something went wrong");
        }
        taskScheduler.finish();
    }
}
