package com.rookied.learning.thread.pc3;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Producer implements Runnable{
    private Goodes goodes;
    public Producer(Goodes goodes){
        this.goodes = goodes;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
           if (i%2==0){
               //goodes = new Goodes("娃哈哈","矿泉水");
               goodes.set("娃哈哈","矿泉水");
           }else {
               //goodes = new Goodes("旺旺","小馒头");
               goodes.set("旺旺","小馒头");
           }
        }
    }
}
