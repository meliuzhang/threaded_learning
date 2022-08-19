package com.lb;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LB
 * @Remarks
 * @date 2020/03/31 21:23
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task has not finished,please wait");
        }
        System.out.println("task return:"+task.get());
    }
}
