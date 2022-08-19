package com.lb;

/**
 * @author LB
 * @Remarks 使用匿名内部类方式创建多线程
 * @date 2020/05/02 14:43
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("i:"+i);
                }
            }
        });

        thread.start();

    }
}
