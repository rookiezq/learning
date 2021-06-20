package com.rookied.learning.thread.pc2;

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
            goodes.get();
        }
    }
}
