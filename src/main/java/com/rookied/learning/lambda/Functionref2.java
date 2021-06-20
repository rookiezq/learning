package com.rookied.learning.lambda;

import java.util.function.Supplier;

/**
 * @author zhangqiang
 * @date 2021/4/22
 */
public class Functionref2 {
    public static void main(String[] args) {
        Functionref2 f2 = new Functionref2();

        Supplier<String> sp = ()-> f2.put();
        System.out.println(sp.get());

        sp = f2::put;
        System.out.println(sp.get());

        sp = new Functionref2()::put;
        System.out.println(sp.get());

    }

    String put() {
        System.out.println("put.....");
        return "put";
    }

}
