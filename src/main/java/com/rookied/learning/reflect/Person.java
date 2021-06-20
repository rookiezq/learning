package com.rookied.learning.reflect;

/**
 * @author zhangqiang
 * @date 2021/6/20
 */
public class Person {
    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String show(){
        return "name:"+name+", age :"+age;
    }
}
