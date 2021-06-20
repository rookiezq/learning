package com.rookied.learning.thread.pc4;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Consumer implements Runnable{
    private BlockingQueue<Goodes> bq;
    public Consumer(BlockingQueue<Goodes> bq){
        this.bq = bq;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Goodes goodes = bq.take();
                System.out.println("消费者消费了"+goodes.getBrand()+goodes.getName()+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
