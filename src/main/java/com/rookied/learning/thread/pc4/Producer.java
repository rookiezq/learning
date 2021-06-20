package com.rookied.learning.thread.pc4;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Producer implements Runnable{
    private BlockingQueue<Goodes> bq;
    public Producer(BlockingQueue<Goodes> bq){
        this.bq = bq;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            Goodes goodes;
           if (i%2==0){
               goodes = new Goodes("娃哈哈","矿泉水");
           }else {
               goodes = new Goodes("旺旺","小馒头");
           }
            try {
                this.bq.put(goodes);
                System.out.println("生产者生产了"+goodes.getBrand()+goodes.getName()+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
