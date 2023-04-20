package com.hspedu.jdbc.mydjbc;

public class OracleJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("链接 Oracle 数据库");
        return null;
    }

    @Override
    public void crud() {
        System.out.println(" Oracle 数据库 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 Oracle 数据库");
    }
}
