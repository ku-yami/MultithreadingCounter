package com.company;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private Integer count;
    private final String name;

    public MyCallable(String name) {
        this.name = name;
        this.count = 0;
    }

    @Override
    public Integer call() throws Exception {

        Random random = new Random();

        /* каждый поток будет пробегать от 1 до 20 раз */
        int anInt = random.nextInt(20);
        for (int i = 0; i < anInt; i++) {
            System.out.printf("Поток %s. Всем привет! Находится на %d круге\n", name, i);
            count++;

            /* Решение для задержки потока на случайное время в диапазоне от 1 до 2.5 секунд */
            int sleepTimer = random.ints(1000, 2501).findFirst().orElse(3000);
            Thread.sleep(sleepTimer);
        }
        return count;
    }
}