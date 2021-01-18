package org.labs.task2;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

/**
 * @author - Марчук Александр
 */
@Slf4j
public class Main2 {

    private static final int AMOUNT_OF_INTERACTIONS = 100;

    public static void main(String[] args) {
        StorageService storageService = new GoodsStorageService(5);

        Initiator seller = new Seller(storageService, AMOUNT_OF_INTERACTIONS);
        Initiator customer = new Customer(storageService, AMOUNT_OF_INTERACTIONS);
        var sellerThread = new Thread(seller);
        var customerThread = new Thread(customer);

        sellerThread.start();
        customerThread.start();
        try {
            sellerThread.join();
        } catch (InterruptedException exc) {
            log.error("Something went wrong");
        }
    }
}
