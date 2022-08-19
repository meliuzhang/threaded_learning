package com.lb;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LB
 * @Remarks 截取list,进行消费
 * @date 2019/12/09 21:00
 */
public class Test_4 {

    public static void main(String[] args) {
        Test_4 test = new Test_4();
        // 准备数据
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 6666; i++) {
            data.add("item" + i);
        }

        test.handleList(data, 5);

        System.out.println(ArrayUtils.toString(data));
    }

    private synchronized void handleList(List<String> data, int threadNum) {
        int length = data.size();
        //每个线程处理多少条
        int tl = length % threadNum == 0 ? length / threadNum : (length / threadNum + 1);

        for (int i = 0; i < threadNum; i++) {
            int end = (i + 1) * tl;
            //开始条数
            int start = i * tl;
            //结束条数
            int endVo = end > length ? length : end;
            System.out.println(i+":"+start+"::"+endVo);
            HandleThread thread = new HandleThread("线程[" + (i + 1) + "] ", data, start, endVo);
            thread.start();
        }
    }

    private class HandleThread extends Thread {

        private String threadName;
        private List<String> data;
        private int start;
        private int end;

        public HandleThread(String threadName, List<String> data, int start, int end) {
            this.threadName = threadName;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            //截取list
            // 使用subList生成与list相同的列表list2
            List<String> subList = data.subList(start, end)   /*.add("^&*")*/;
            System.out.println(threadName+"处理了"+subList.size()+"条！");
        }
    }
}
