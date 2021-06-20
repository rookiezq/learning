package com.rookied.learning.jdbc.dao.impl;

import com.rookied.learning.jdbc.dao.BaseDao;
import com.rookied.learning.jdbc.entity.Dept;
import com.rookied.learning.jdbc.entity.Emp;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDaoImplTest {
    BaseDao db = new BaseDaoImpl();
    @Test
    public void save() {
        Emp emp = new Emp(3335, "sisi123", "SALES", 1111, "2019-11-09", 1500.0, 500.0, 10);
        //db.save(emp);

        Dept dept = new Dept(50,"JACK","aaaa");
        db.save(dept);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void select() {
    }
}