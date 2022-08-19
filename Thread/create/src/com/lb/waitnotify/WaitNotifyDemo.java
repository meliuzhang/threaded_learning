package com.lb.waitnotify;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        //等待唤醒案例
        //创建包子对象
        BaoZi bz = new BaoZi();
        ChiHuo ch = new ChiHuo( bz);
        BaoZiPu bzp = new BaoZiPu( bz);
        ch.start();
        bzp.start();
    }
}
