package org.labs.task2;

import lombok.AllArgsConstructor;

/**
 * Абстрактный класс-инициатор взаимодействия со складом
 */
@AllArgsConstructor
public abstract class Initiator implements Runnable {

    protected StorageService storage;
    protected int amountOfInteractions;

    @Override
    public void run() {
        for (int i = 0; i < amountOfInteractions; i++) {
            doConcreteActions();
        }
    }

    protected abstract void doConcreteActions();
}
