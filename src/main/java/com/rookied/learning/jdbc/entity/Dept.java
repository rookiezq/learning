package com.rookied.learning.jdbc.entity;

/**
 * @author zhangqiang
 * @date 2021/6/20
 */
public class Dept {
    private int deptno;
    private String dname;
    private String loc;

    public Dept() {
    }

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public Dept setDeptno(int deptno) {
        this.deptno = deptno;
        return this;
    }

    public String getDname() {
        return dname;
    }

    public Dept setDname(String dname) {
        this.dname = dname;
        return this;
    }

    public String getLoc() {
        return loc;
    }

    public Dept setLoc(String loc) {
        this.loc = loc;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dept");
        sb.append("[");
        sb.append("deptno=").append(deptno);
        sb.append("| dname='").append(dname).append('\'');
        sb.append("| loc='").append(loc).append('\'');
        sb.append(']');
        return sb.toString();
    }
}
