package com.lb.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    //读写锁
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    static Lock r = rwl.readLock();
    //写锁
    static Lock w = rwl.writeLock();

    public static final Object get(String key) {
        //加读锁
        r.lock();
        try {
            System.out.println("正在做读的操作,key:" + key + " 开始");
            Thread.sleep(1000);
            Object object = map.get(key);
            System.out.println("正在做读的操作,key:" + key + " 结束");
            return object;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放读锁
            r.unlock();
        }
        return key;
    }

    // 设置key对应的value，并返回旧有的value
    public static final Object put(String key, Object value) {
        //加写锁
        w.lock();
        try {
            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "开始.");
            Thread.sleep(1000);
            Object object = map.put(key, value);
            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "结束.");
            return object;
        } catch (InterruptedException e) {

        } finally {
            //释放写锁
            w.unlock();
        }
        return value;
    }

    // 清空所有的内容
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Cache.put(i+"",i+"");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Cache.get(i+"");
                }
            }
        }).start();
    }
}
