package com.lb.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClassDemo implements Runnable{

    private static Integer count = 1;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true){
            int count = getCountAtomic();
            if(count >= 150){
                break;
            }
            System.out.println(count);
        }
    }

    private int getCountAtomic() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //每次自增，相当于i++
        return atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicClassDemo atomicClassDemo = new AtomicClassDemo();
        Thread t1 = new Thread(atomicClassDemo);
        Thread t2 = new Thread(atomicClassDemo);
        t1.start();
        t2.start();
    }

}
