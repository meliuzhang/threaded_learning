package com.lb.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThradDemo001 extends Thread {

    private String name;

    private Semaphore wc;

    public ThradDemo001(String name, Semaphore wc) {
        this.name = name;
        this.wc = wc;
    }

    @Override
    public void run() {
        // 剩下的资源
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0) {
            System.out.println(name + "终于有茅坑了.....");
        } else {
            System.out.println(name + "怎么没有茅坑了...");
        }
        try {
            // 申请资源
            wc.acquire();
        } catch (InterruptedException e) {

        }
        System.out.println(name + "终于上厕所啦" + ",剩下厕所:" + wc.availablePermits());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(name + "厕所上完啦!");
        // 释放资源
        wc.release();
    }
}
