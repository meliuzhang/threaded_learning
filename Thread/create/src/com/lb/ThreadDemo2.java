package com.lb;

/**
 * @author LB
 * @Remarks 实现Runnable接口,重写run方法开启多线程
 * @date 2020/05/02 14:38
 */
public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i:"+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo2);
        thread.start();
    }
}
