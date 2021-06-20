package com.rookied.learning.reflect;

import com.rookied.learning.jdbc.entity.Emp;

/**
 * @author zhangqiang
 * @date 2021/6/20
 */
public class CreateClassObject {
    public static void main(String[] args) throws Exception {

        //1.通过class.forname()来获取Class对象
        //Class clazz = Class.forName("com.rookied.learning.jdbc.entity.Emp");
        //2.通过类名.class获取
        //Class<Emp> clazz = Emp.class;
        //3.通过对象获取
        Class clazz = new Emp().getClass();
        //返回包名
        System.out.println(clazz.getPackage());
        //返回由 类对象表示的实体（类，接口，数组类，原始类型或空白）的名称
        System.out.println(clazz.getName());
        //返回类名
        System.out.println(clazz.getSimpleName());
        //返回由Java语言规范定义的基础类的规范名称
        System.out.println(clazz.getCanonicalName());
    }
}
