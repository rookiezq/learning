package com.rookied.learning.thread.pc4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class PcTest {
    public static void main(String[] args) {
        BlockingQueue<Goodes> bq = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(bq);
        Consumer consumer = new Consumer(bq);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
