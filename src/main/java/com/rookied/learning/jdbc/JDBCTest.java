package com.rookied.learning.jdbc;

import java.sql.*;

/**
 * @author zhangqiang
 * @date 2021/6/18
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?useSSL=false","root","root");
        //3.定义sql语句
        String sql = "select * from emp";
        System.out.println(sql);
        //4.准备静态处理块对象,用于放置sql语句
        Statement statement = connection.createStatement();
        //5.执行sql语句,返回结果集
        ResultSet resultSet = statement.executeQuery(sql);
        //6.循环处理
        while(resultSet.next()){
            System.out.println("empno:"+resultSet.getInt(1));
            System.out.println("ename:"+resultSet.getString("ename"));
            System.out.println("-------");
        }
        //7.关闭连接
        statement.close();
        connection.close();
    }
}
