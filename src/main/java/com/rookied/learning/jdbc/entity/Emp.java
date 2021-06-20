package com.rookied.learning.jdbc.entity;

/**
 * @author zhangqiang
 * @date 2021/6/19
 */
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    public Emp(){

    }

    public Emp(Integer empno, String ename, String job, Integer mgr, String hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public Emp setEmpno(Integer empno) {
        this.empno = empno;
        return this;
    }

    public String getEname() {
        return ename;
    }

    public Emp setEname(String ename) {
        this.ename = ename;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Emp setJob(String job) {
        this.job = job;
        return this;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Emp setMgr(Integer mgr) {
        this.mgr = mgr;
        return this;
    }

    public String getHiredate() {
        return hiredate;
    }

    public Emp setHiredate(String hiredate) {
        this.hiredate = hiredate;
        return this;
    }

    public Double getSal() {
        return sal;
    }

    public Emp setSal(Double sal) {
        this.sal = sal;
        return this;
    }

    public Double getComm() {
        return comm;
    }

    public Emp setComm(Double comm) {
        this.comm = comm;
        return this;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public Emp setDeptno(Integer deptno) {
        this.deptno = deptno;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Emp");
        sb.append("[");
        sb.append("empno=").append(empno);
        sb.append("| ename='").append(ename).append('\'');
        sb.append("| job='").append(job).append('\'');
        sb.append("| mgr=").append(mgr);
        sb.append("| hiredate='").append(hiredate).append('\'');
        sb.append("| sal=").append(sal);
        sb.append("| comm=").append(comm);
        sb.append("| deptno=").append(deptno);
        sb.append(']');
        return sb.toString();
    }
}
