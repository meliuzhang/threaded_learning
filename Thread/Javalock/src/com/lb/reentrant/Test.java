package com.lb.reentrant;

public class Test implements Runnable {

    public synchronized void get(){
        System.out.println("name:"+Thread.currentThread().getName()+"get();");
        set();
    }

    private synchronized void set() {
        System.out.println("name:"+Thread.currentThread().getName()+"set();");
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Test ss = new Test();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
