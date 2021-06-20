package com.rookied.learning.lambda;



import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zhangqiang
 * @date 2021/4/22
 */
public class Functionref3 {
    public static void main(String[] args) {
        BiFunction<Functionref3,String,Integer> bf1 = (e, s)->new Functionref3().test(s);
        System.out.println(bf1.apply(new Functionref3(), "abc"));
        BiFunction<Functionref3,String,Integer> bf2 = Functionref3::test;
        System.out.println(bf2.apply(new Functionref3(), "defh"));
        Function<String,Integer> f = String::length;
        System.out.println(f.apply("qwerty"));//输出6

        Function<String, String> f1 = (str)->new String(str);
        System.out.println(f1.apply("abc"));

        Function<String,String> f2 = String::new;
        System.out.println(f2.apply("def"));
    }

    public int test(String name){
        return 1+name.length();
    }

}
