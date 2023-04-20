package com.hspedu.jdbc.mydjbc;

public class MySqlJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到MySQL的链接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成mysql的增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭MySQL的链接...");
    }
}
