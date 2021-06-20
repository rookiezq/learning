package com.rookied.learning.lambda;

import java.util.function.Supplier;

/**
 * @author zhangqiang
 * @date 2021/4/22
 */
public class Functionref {
    public static void main(String[] args) {
        Supplier<String> sp = ()->Functionref.put();
        System.out.println(sp.get());

        sp = Functionref::put;
        System.out.println(sp.get());
    }

    static String put() {
        System.out.println("put.....");
        return "put";
    }

}
