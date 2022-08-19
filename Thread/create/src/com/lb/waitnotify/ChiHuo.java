package com.lb.waitnotify;

public class ChiHuo extends Thread {
    private BaoZi bz;

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) {//没包子
                    try {
                        bz.wait();//进入无限等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 代码执行到这里, 说明有包子了
                // 吃包子
                try {
                    System.out.println("消费者正在吃包子。。");
                    Thread.sleep(1500);
                    System.out.println("包子吃完了, 包子铺快来做!~");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改是否有包子变量为false: 代表包子已经吃完了
                bz.flag = false;
                //唤醒包子铺来做包子
                bz.notify();
            }
        }
    }
}
