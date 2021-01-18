package org.labs.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.TimerTask;

import static org.labs.task1.SimpleStrUtil.SEPARATE_LINE;
import static org.labs.task1.SimpleStrUtil.getTimeLogStr;

@Slf4j
@Getter
@AllArgsConstructor
public class TaskExecutor extends TimerTask {

    private String texture;
    private int seconds;

    @Override
    public void run() {
        val logMessage = getTimeLogStr(texture);
        log.info(logMessage + "\n" + SEPARATE_LINE);
    }
}
