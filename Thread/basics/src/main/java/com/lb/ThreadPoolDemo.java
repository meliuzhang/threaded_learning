package com.lb;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author LB
 * @Remarks
 * @date 2020/03/31 21:35
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //可缓存线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("task has not finished,please wait!");
        }
        try {
            System.out.println("task return:"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();//关闭资源
        }
    }
}
