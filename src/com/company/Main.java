package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int NUMBER_OF_THREADS = 4;

        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            String threadName = "" + i;
            tasks.add(new MyCallable(threadName));
        }

        Integer result = pool.invokeAny(tasks);

        pool.shutdown();

        System.out.printf("Самый быстрый поток закончил на %s круге\n", result);
    }
}
