package com.rookied.learning.jdbc.dao;

import com.rookied.learning.jdbc.entity.Emp;

import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/6/19
 */
public interface BaseDao {
    //插入数据
    public void save(Object object);

    //删除数据
    public void delete(Object object);

    //修改数据
    public void update(Object object);

    //查找数据
    public List select(String sql,Object[] objects,Class clazz);

}
