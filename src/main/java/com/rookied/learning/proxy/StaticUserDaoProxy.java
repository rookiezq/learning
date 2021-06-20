package com.rookied.learning.proxy;

/**
 * @author zhangqiang
 * @date 2020/3/28
 */
public class StaticUserDaoProxy implements IUserDao {
    private IUserDao target;
    public StaticUserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
