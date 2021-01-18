package org.labs.task2;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Customer extends Initiator implements Runnable {

    public Customer(StorageService storage, int amountOfInteractions) {
        super(storage, amountOfInteractions);
    }

    @Override
    protected void doConcreteActions() {
        takeGoodsFromStorage();
    }

    private void takeGoodsFromStorage() {
        storage.release();
        log.info(LocalDateTime.now() + " Покупка товара");
    }

}
