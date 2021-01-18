package org.labs.task2;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@RequiredArgsConstructor
public class GoodsStorageService implements StorageService {

    @NonNull
    private int capacity;
    private int currentGoodsAmount;

    @Override
    public synchronized void release() {
        while (currentGoodsAmount >= capacity) {
            doWaiting();
        }
        currentGoodsAmount++;
        callLoggerAndNotify();
    }

    @Override
    public synchronized void receive() {
        while (currentGoodsAmount < 1) {
            doWaiting();
        }
        currentGoodsAmount--;
        callLoggerAndNotify();
    }

    private void doWaiting() {
        try {
            wait();
        } catch (InterruptedException exc) {
            log.error("Something went wrong");
        }
    }

    private void callLoggerAndNotify() {
        log.info(LocalDateTime.now() + "Количество товара теперь: " + currentGoodsAmount + "\n");
        notify();
    }

}
