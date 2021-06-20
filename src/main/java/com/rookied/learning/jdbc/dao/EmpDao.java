package com.rookied.learning.jdbc.dao;

import com.rookied.learning.jdbc.entity.Emp;

/**
 * @author zhangqiang
 * @date 2021/6/19
 */
public interface EmpDao {
    //插入数据
    public void insert(Emp emp);

    //删除数据
    public void delete(Emp emp);

    //修改数据
    public void update(Emp emp);

    //查找数据
    public Emp getEmpByEmpno(Integer empno);

    public Emp getEmpByEname(String name);
}
