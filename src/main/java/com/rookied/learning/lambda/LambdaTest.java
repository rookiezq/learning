package com.rookied.learning.lambda;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zhangqiang
 * @date 2021/4/22
 */
public class LambdaTest {
    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("running1....");
            }
        };
        r.run();

        r = () -> {System.out.println("running2...");};
        r.run();

        r = ()->System.out.println("running3...");
        r.run();

        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callbale1";
            }
        };
        System.out.println(c.call());

        c = ()->{return "callable2";};
        System.out.println(c.call());

        c = ()->"callable3";
        System.out.println(c.call());

        Student s = new Student();
        StudentDao sd = (st)->{System.out.println("插入学生1");};
        sd.insert(s);

        sd = (st)->System.out.println("插入学生2");
        sd.insert(s);

        Teacher t = new Teacher();
        TeacherDao td = (te)->{return 1;};
        System.out.println(td.get(t));

        td = (te)->1;
        System.out.println(td.get(t));

        td = (Teacher te)->1;
        System.out.println(td.get(t));

        Function<String,Integer> f = (str)-> {
            return str.length();
        };
        System.out.println(f.apply("qwer"));

        f = (str)->str.length();
        System.out.println(f.apply("qwert"));

        f = String::length;
        System.out.println(f.apply("qwerty"));

        BiFunction<String,String,Integer> bi = (a,b)->a.length()+b.length();
        System.out.println(bi.apply("qwe", "qwer"));

        Runnable r1 = ()->get();

        TeacherDao td1 = (te)->te!=null?1:2;

    }

    static int get(){
        return 1;
    }
}
