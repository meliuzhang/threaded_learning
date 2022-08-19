package com.lb.synchronize;

/**
 * @author LB
 * @Remarks
 * @date 2020/04/02 20:49
 */
public class SyncDemo {
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread A_thread1 = new Thread(new SyncThread(), "A_thread1");
        Thread A_thread2 = new Thread(new SyncThread(), "A_thread2");
        Thread D_thread1 = new Thread(new SyncThread(), "D_thread1");
        Thread D_thread2 = new Thread(new SyncThread(), "D_thread2");
        Thread E_thread1 = new Thread(new SyncThread(), "E_thread1");
        Thread E_thread2 = new Thread(new SyncThread(), "E_thread2");
        A_thread1.start();
        A_thread2.start();
        D_thread1.start();
        D_thread2.start();
        E_thread1.start();
        E_thread2.start();
    }
}
