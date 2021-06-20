package com.rookied.learning.proxy;

/**
 * @author zhangqiang
 * @date 2020/3/28
 */
public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
