package com.mickszhu.demo.utiles;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingQueueTestProblem {

    private final static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            final String log = "" + (i + 1);
            executor.execute(new MyRunnable(log));
        }
    }

    public static void parseLog(String log) throws InterruptedException {
        System.out.println(log + ":" + System.currentTimeMillis() / 1000);
        Thread.sleep(1000);
    }

}


class MyRunnable implements Runnable {
    private String log;

    MyRunnable(String log) {
        this.log = log;
    }

    @Override
    public void run() {
        try {
            System.out.println(log + ":" + System.currentTimeMillis() / 1000);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
