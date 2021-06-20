package com.rookied.learning.lambda;

/**
 * @author zhangqiang
 * @date 2021/4/22
 */
@FunctionalInterface
public interface StudentDao {
    void insert(Student student);
}
