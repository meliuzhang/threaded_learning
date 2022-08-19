package threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 描述：     演示关闭线程池
 */
public class  ShutDown {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ShutDownTask());
        }
        Thread.sleep(1500);
       List<Runnable> runnableList = executorService.shutdownNow();

        //isShutdown()返回布尔值true或false告诉我们线程是否进入停止状态
        //System.out.println("isShutdown="+executorService.isShutdown());
        //告诉线程池我想让你停止。使用之后，不会增加新的任务，会把存量的（队列中的）任务执行完毕，
        //executorService.shutdown();
        //isShutdown()返回布尔值true或false告诉我们线程是否进入停止状态
        //System.out.println("isShutdown="+executorService.isShutdown());
        //isTerminated（）线程完全停止（不再接受新的任务存量任务也执行完毕）会返回true，否则返回false
        //System.out.println("isTerminated="+executorService.isTerminated());
        //使用shutdown之后再提交新的任务会报错（用于演示shutdown启作用了）
        //executorService.execute(new ShutDownTask());
        //boolean b = executorService.awaitTermination(7L, TimeUnit.SECONDS);
        //System.out.println(b);
//        System.out.println(executorService.isShutdown());
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//        Thread.sleep(10000);
//        System.out.println(executorService.isTerminated());

//        executorService.execute(new ShutDownTask());
    }
}

class ShutDownTask implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        }
    }
}
