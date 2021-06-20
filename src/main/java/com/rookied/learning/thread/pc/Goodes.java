package com.rookied.learning.thread.pc;

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
}
