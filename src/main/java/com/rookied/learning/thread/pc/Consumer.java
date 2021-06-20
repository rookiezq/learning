package com.rookied.learning.thread.pc;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Consumer implements Runnable{
    private Goodes goodes;
    public Consumer(Goodes goodes){
        this.goodes = goodes;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者消费了"+this.goodes.getBrand()+this.goodes.getName());
        }
    }
}
