package com.lb.waitnotify;

public class BaoZiPu extends Thread {

    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }


    @Override
    public void run() {
        //造包子
        while (true) {
            //同步
            synchronized (bz) {
                if (bz.flag == true) {//包子资源存在
                    try {
                        bz.wait();//进入无限等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 代码执行到这里, 说明没有包子了，没有包子 造包子
                try {
                    System.out.println("包子铺开始做包子");
                    Thread.sleep(1000);
                    System.out.println("包子做好了,吃货来吃吧");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改是否有包子变量为 true :  代表包子已经做好了
                bz.flag = true;
                //唤醒等待线程(唤醒吃货)
                bz.notify();
            }

        }

    }
}
