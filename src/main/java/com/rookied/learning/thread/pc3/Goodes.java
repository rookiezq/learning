package com.rookied.learning.thread.pc3;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Goodes {
    String name;
    String brand;
    //默认false表示生产者还没生产,或者是消费者已经消费完
    boolean flag = false;

    public Goodes() {
    }

    public Goodes(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public synchronized void set(String brand,String name){
        //生产完成,等待消费者消费
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand()+this.getName());
        //生产完成,通知消费
        flag = true;
        notify();
    }

    public synchronized void get(){
        //消费完成,等待生产
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了"+this.getBrand()+this.getName());
        //消费完成,通知生产
        flag = false;
        notify();
    }
}
