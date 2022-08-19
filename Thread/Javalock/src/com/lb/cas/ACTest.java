package com.lb.cas;

public class ACTest implements Runnable {

    private static Integer count = 1;

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

    private  int getCountAtomic() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return count++;
    }

    public static void main(String[] args) {
        ACTest acTest = new ACTest();
        Thread t1 = new Thread(acTest);
        Thread t2 = new Thread(acTest);
        t1.start();
        t2.start();
    }
}
