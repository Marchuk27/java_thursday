package org.labs.task2;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Seller extends Initiator implements Runnable {

    public Seller(StorageService storage, int amountOfInteractions) {
        super(storage, amountOfInteractions);
    }

    @Override
    protected void doConcreteActions() {
        shipGoodsToStorage();
    }

    private void shipGoodsToStorage() {
        storage.receive();
        log.info(LocalDateTime.now() + " Поставка товара на склад");
    }
}
