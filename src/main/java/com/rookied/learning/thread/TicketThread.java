package com.rookied.learning.thread;

/**
 * @author zhangqiang
 * @date 2021/4/19
 */
public class TicketThread implements Runnable{
    private Integer ticket = 5;
    @Override
    public void run() {
        //for(int i=0;i<100;i++){
            synchronized (this) {
                if (ticket > 0) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                    System.out.println(Thread.currentThread().getName() + "买了一张,还剩" + ticket-- + "张");
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}
    }

    public static void main(String[] args) {
        TicketThread tt = new TicketThread();
        new Thread(tt,"A").start();
        new Thread(tt,"B").start();
        new Thread(tt,"C").start();
        new Thread(tt,"D").start();
        new Thread(tt,"E").start();
    }
}
