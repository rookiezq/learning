package com.rookied.learning.day1009;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangqiang
 * @date 2019-10-09
 */
public class demo1 implements MethodInterceptor {
    static Map<StringBuilder,Integer> map = new HashMap<>();
    static final Integer i =1;
    static StringBuilder sb = new StringBuilder("a");
    static final String string = "asd";
    public static void main(String[] args) {
        System.out.println(string);
        map.put(sb,i);
        for (StringBuilder s: map.keySet()) {
            System.out.println(s+"----"+map.get(s));
        }
    }

    public static void fun(StringBuilder sb){
        map.put(sb,i+1);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Enhancer enhancer = new Enhancer();
        return null;
    }
}
