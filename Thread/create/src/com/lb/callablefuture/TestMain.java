package com.lb.callablefuture;

import java.util.concurrent.*;

public class TestMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //可缓存线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("####AddNumberTask###call()");
                Thread.sleep(5000);
                return 5000;
            }
        });
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        // get() ：获取异步执行的结果，如果没有结果可用，此方法会阻塞直到异步计算完成。
        Integer integer = future.get();
        System.out.println(integer);
        if(executor != null){
            executor.shutdown();
        }
    }
}
