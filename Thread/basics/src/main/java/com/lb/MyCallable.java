package com.lb;

import java.util.concurrent.Callable;

/**
 * @author LB
 * @Remarks
 * @date 2020/03/31 21:20
 */
public class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
