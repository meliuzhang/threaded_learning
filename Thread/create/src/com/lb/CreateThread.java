package com.lb;

/**
 * @author LB
 * @Remarks 继承Thread类重写run方法创建线程
 * @date 2020/05/02 14:32
 */
public class CreateThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i:"+i);
        }
    }

    public static void main(String[] args) {
        // 1.创建一个线程
        CreateThread createThread = new CreateThread();
        // 2.开始执行线程 注意 开启线程不是调用run方法，而是start方法
        createThread.start();

    }
}

