package com.rookied.learning.jdbc.dao.impl;

import com.rookied.learning.jdbc.dao.EmpDao;
import com.rookied.learning.jdbc.entity.Emp;
import com.rookied.learning.jdbc.util.DBUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zhangqiang
 * @date 2021/6/19
 */
public class EmpDaoImpl2 implements EmpDao {
    @Override
    public void insert(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            statement.setString(2,emp.getEname());
            statement.setString(3,emp.getJob());
            statement.setInt(4,emp.getMgr());
            statement.setDate(5,new Date(new SimpleDateFormat("yyyy-MM-dd").parse(emp.getHiredate()).getTime()));
            statement.setDouble(6,emp.getSal());
            statement.setDouble(7,emp.getComm());
            statement.setInt(8,emp.getDeptno());
            int i = statement.executeUpdate();
            System.out.println("受影响的行数是：" + i);
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public void delete(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from emp where empno=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,emp.getEmpno());
            System.out.println(sql);
            int i = statement.executeUpdate();
            System.out.println("受影响的行数是：" + i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public void update(Emp emp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update emp set job =? where empno =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,emp.getJob());
            statement.setInt(2,emp.getEmpno());
            System.out.println(sql);
            int i = statement.executeUpdate();
            System.out.println("受影响的行数是：" + i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement);
        }
    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from emp where empno =?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,empno);
            System.out.println(sql);
            resultSet = statement.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement,resultSet);
        }
        return emp;
    }

    @Override
    public Emp getEmpByEname(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from emp where ename =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            System.out.println(sql);
            resultSet = statement.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (resultSet.next()){
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"), resultSet.getString("job"),
                        resultSet.getInt("mgr"), sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"), resultSet.getInt("deptno"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, statement,resultSet);
        }
        return emp;
    }

    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl2();
        Emp emp = new Emp(3334, "sisi123", "SALES", 1111, "2019-11-09", 1500.0, 500.0, 10);
        empDao.insert(emp);
        //empDao.update(emp);
        //empDao.delete(emp);
        //Emp emp2 = empDao.getEmpByEmpno(7369);
        //sql注入
        //Emp emp2 = empDao.getEmpByEname("SMITH");
        //Emp emp2 = empDao.getEmpByEname("'SMITH' or 1=1");
        //System.out.println(emp2);
    }
}
