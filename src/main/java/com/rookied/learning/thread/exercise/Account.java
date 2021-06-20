package com.rookied.learning.thread.exercise;

/**
 * @author zhangqiang
 * @date 2021/4/19
 */
public class Account implements Runnable {
    double balance = 1000.0;

    public void takeMoney(double money) {
        this.balance -= money;
        if (this.balance <= 0) {
            this.balance = 0;
            System.out.println("余额不足以支付 " + Thread.currentThread().getName() + " 的取款,余额为 " + this.balance);
        }
        System.out.println(Thread.currentThread().getName() + "完成取款");
    }


    @Override
    public void run() {

        while (this.balance >= 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "准备取款");
                this.balance -= 20;
                if (this.balance < 0) {
                    this.balance = 0;
                    System.out.println("余额不足以支付 " + Thread.currentThread().getName() + " 的取款,余额为 " + this.balance);
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "完成取款");
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        Thread t1 = new Thread(account, "张三");
        Thread t2 = new Thread(account, "张三的妻子");
        t1.start();
        t2.start();
    }
}
