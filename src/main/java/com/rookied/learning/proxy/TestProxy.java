package com.rookied.learning.proxy;

/**
 * @author zhangqiang
 * @date 2020/3/28
 */
import org.junit.Test;

public class TestProxy {

    @Test
    public void testCglibProxy(){
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();
        //System.out.println(proxy);
        //执行代理对象方法
        //proxy.save();
    }

    @Test
    public void testDynamicProxy (){
        IUserDao target = new UserDao();
        System.out.println(target.getClass());  //输出目标对象信息
        IUserDao proxy = (IUserDao) new DynamicProxyFactory(target).getProxyInstance();
        System.out.println(proxy);  //输出代理对象信息
        //proxy.save();  //执行代理方法
    }

    @Test
    public void testStaticProxy(){
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        StaticUserDaoProxy proxy = new StaticUserDaoProxy(target);
        System.out.println(proxy);
        proxy.save();
    }
}
