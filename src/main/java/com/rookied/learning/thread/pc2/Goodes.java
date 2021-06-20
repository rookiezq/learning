package com.rookied.learning.thread.pc2;

/**
 * @author zhangqiang
 * @date 2021/4/20
 */
public class Goodes {
    String name;
    String brand;

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
        this.setBrand(brand);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了"+this.getBrand()+this.getName());
    }

    public synchronized void get(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了"+this.getBrand()+this.getName());
    }
}
