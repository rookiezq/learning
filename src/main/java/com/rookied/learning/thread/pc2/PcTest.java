package com.rookied.learning.thread.pc2;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class PcTest {
    public static void main(String[] args) {
        Goodes goodes = new Goodes();
        Producer producer = new Producer(goodes);
        Consumer consumer = new Consumer(goodes);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
