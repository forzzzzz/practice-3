package org.example;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class MainTest {
    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            Worker worker = new Worker(queue);
            executor.submit(worker);
        }

        for (int i = 0; i < 4; i++) {
            final int taskId = i;
            queue.offer(() -> {

                System.out.println();
                System.out.println("Task " + taskId + " finished. Queue: " + queue.size());

                double v = Math.random() * 360.0;
                double r1 = Math.random() * 360.0;
                double r2 = Math.random() * 360.0;
                double r3 = Math.random() * 360.0;
                double r4 = Math.random() * 360.0;

                Calc.initAndShowResult(v, r1, r2, r3, r4);
                Calc.showValues();
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Execution interrupted");
        }
    }
}