package com.lb.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            ThradDemo001 thradDemo001 = new ThradDemo001("第" + i + "个人", semaphore);
            thradDemo001.start();

        }
    }
}
