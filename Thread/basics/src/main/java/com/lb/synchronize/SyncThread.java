package com.lb.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LB
 * @Remarks
 * @date 2020/04/02 20:31
 */
public class SyncThread implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if(threadName.startsWith("A")){
            async();
        }else if(threadName.startsWith("D")){
            syncClassBlock1();
        }else if(threadName.startsWith("E")){
            syncClassMethod1();
        }

    }

    /**异步方法*/
    private void async(){
        try {
            System.out.println(Thread.currentThread().getName()+"_Async_Start:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_Async_End:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**方法中有synchronized（this|object）{}同步代码块 类锁*/
    private void syncClassBlock1(){
        System.out.println(Thread.currentThread().getName()+"SyncClassBlock1:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (SyncThread.class){
            try {
                System.out.println(Thread.currentThread().getName()+"_SyncClassBlock1_Start:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"_SyncClassBlock1_End:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**synchronized修饰静态方法*/
    private  synchronized static void syncClassMethod1(){
        System.out.println(Thread.currentThread().getName()+"SyncClassMethod1:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName()+"_SyncClassMethod1_Start:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"_SyncClassMethod1_End:"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
