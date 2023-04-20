package com.hspedu.jdbc.mydjbc;

public class TestJDBC {
    public static void main(String[] args) {
        JdbcInterface JdbcConnection = new MySqlJdbcImpl();
        JdbcConnection.getConnection();
        JdbcConnection.crud();
        JdbcConnection.close();

        System.out.println("========================");

        JdbcConnection = new OracleJdbcImpl();
        JdbcConnection.getConnection();
        JdbcConnection.crud();
        JdbcConnection.close();

    }
}
