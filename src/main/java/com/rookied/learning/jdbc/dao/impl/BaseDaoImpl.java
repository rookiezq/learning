package com.rookied.learning.jdbc.dao.impl;

import com.rookied.learning.jdbc.dao.BaseDao;
import com.rookied.learning.jdbc.entity.Dept;
import com.rookied.learning.jdbc.entity.Emp;
import com.rookied.learning.jdbc.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangqiang
 * @date 2021/6/19
 */
public class BaseDaoImpl implements BaseDao {
    private static final String INSERT_PREFIX = "insert into ? values(";

    @Override
    public void save(Object object) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class<?> aClass = object.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            String sql = completeSql(aClass.getSimpleName(), declaredFields.length);
            System.out.println("sql语句为: " + sql);
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                //根据列名获取get方法
                //Method getMethod = aClass.getDeclaredMethod(getGetName(field.getName()));

                ps.setObject(i+1,field.get(object));
            }
            int i = ps.executeUpdate();
            System.out.println("受影响的行数是：" + i);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection, ps);
        }
    }

    /**
     * 按照字段个数补充问号
     *
     * @param tName  表名
     * @param length 所有字段个数
     */
    private String completeSql(String tName, int length) {
        //将类名的小写填入sql
        String tmp = INSERT_PREFIX.replace("?", tName.toLowerCase());
        StringBuilder sb = new StringBuilder(tmp);
        for (int i = 0; i < length; i++) {
            sb.append("?,");
        }
        //将最后一位逗号替换为)
        sb.replace(sb.length() - 1, sb.length(), ")");
        return sb.toString();
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public List select(String sql, Object[] objects, Class clazz) {
        List<Object> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSetMetaData rsmd = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            //元数据
            rsmd = ps.getMetaData();
            //结果集
            rs = ps.executeQuery();
            //字段数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                Object o = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnName(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    //System.out.print(getSetName(columnName)+", ");
                    Method method = clazz.getDeclaredMethod(getSetName(columnName), field.getType());
                    if (value instanceof Number) {
                        Number number = (Number) value;
                        String fname = field.getType().getName();
                        if ("int".equals(fname) || "java.lang.Integer".equals(fname)) {
                            method.invoke(o, number.intValue());
                        } else if ("byte".equals(fname) || "java.lang.Byte".equals(fname)) {
                            method.invoke(o, number.byteValue());
                        } else if ("short".equals(fname) || "java.lang.Short".equals(fname)) {
                            method.invoke(o, number.shortValue());
                        } else if ("long".equals(fname) || "java.lang.Long".equals(fname)) {
                            method.invoke(o, number.longValue());
                        } else if ("float".equals(fname) || "java.lang.Float".equals(fname)) {
                            method.invoke(o, number.floatValue());
                        } else if ("double".equals(fname) || "java.lang.Double".equals(fname)) {
                            method.invoke(o, number.doubleValue());
                        }
                    } else if (value instanceof Date) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        method.invoke(o, sdf.format(value));
                    } else {
                        method.invoke(o, value);
                    }
                }
                list.add(o);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection, ps, rs);
        }

        return list;
    }

    private String getSetName(String columnName) {
        return "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
    }


    public static void main(String[] args) {
        BaseDao db = new BaseDaoImpl();
        //List select = db.select("select * from emp where deptno=?", new Object[]{10}, Emp.class);
        List select = db.select("select * from dept", new Object[]{}, Dept.class);
        for (Object o : select) {
            //System.out.println((Emp) o);
            System.out.println((Dept) o);
        }
    }
}
