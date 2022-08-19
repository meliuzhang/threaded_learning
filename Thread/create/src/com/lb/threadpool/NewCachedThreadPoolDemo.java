package com.lb.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LB
 * @Remarks 可缓存线程池:比较适合任务量大但耗时少的任务
 * @date 2020/05/02 15:06
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool  = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
                }
            });
        }
        //关闭线程池,会继续执行正在执行未完成的任务
        newCachedThreadPool.shutdown();
    }
}
