package com.lb;

/**
 * @author LB
 * @Remarks
 * @date 2020/03/31 20:44
 */
public class CycleWait  implements Runnable{
    private String value;
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }
    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();
//        while (cw.value == null){
//            Thread.currentThread().sleep(100);
//        }
        t.join();
        System.out.println("value:"+cw.value);
    }
}
