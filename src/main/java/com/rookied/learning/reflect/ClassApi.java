package com.rookied.learning.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangqiang
 * @date 2021/6/20
 */
public class ClassApi {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.rookied.learning.reflect.Student");
        //获取成员变量,包括子类及父类，只能获取public的
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            //字段名
            System.out.println(field.getName());
            //字段类型
            System.out.println(field.getType());
            //字段修饰符
            System.out.println(field.getModifiers());
            System.out.println("--------");
        }
        System.out.println("=======================");
        //此方法返回的是当前类的所有属性，不仅仅局限于public，所有的访问修饰符都可以拿到
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        System.out.println("========================");
        //获取指定名字字段
        Field address = clazz.getDeclaredField("address");
        System.out.println(address.getName());
        Object o = clazz.newInstance();
        //private的字段需要设置属性是否能访问,public不需要,true表示可以,破坏了封装性
        address.setAccessible(true);
        address.set(o,"北京");
        System.out.println(((Student)o).getAddress());
        System.out.println(address.get(o));
        System.out.println("========================");
        //获取该对象的普通方法,包含的方法范围是当前对象及父类对象的所有public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("========================");
        //获取当前类中所有的方法，无论什么访问修饰符
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("--------------");
        //获取指定名字方法,并传入参数的类型
        Method add = clazz.getDeclaredMethod("add", int.class, int.class);
        //私有方法设置可访问
        add.setAccessible(true);
        Object o1 = clazz.newInstance();
        //调用方法,传入调用对象和实参
        add.invoke(o1,123,123);
        System.out.println("----------------------");
        //获取对象的所有构造方法，只能获取公有的改造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("--------------");
        //获取所有的构造方法，无论是私有还是公有
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        //如何调用私有的构造方法呢？
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor.setAccessible(true);
        Student o2 = (Student)declaredConstructor.newInstance("msb", 23, "java");
        System.out.println(o2);
    }
}
