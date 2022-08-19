package com.lb.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LB
 * @Remarks 定长线程池：适用于任务量比较固定但耗时长的任务
 * @date 2020/05/02 15:13
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ",i:" + temp);
                }
            });
        }
    }
}
