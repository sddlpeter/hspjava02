package com.hspedu.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class _C3P0 {
    // 方式1. 相关参数，在程序中指定

    @Test
    public void testC3P0_01() throws Exception {

        // 由实现了datasource接口的连接池库函数，拿到连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\info.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 连接池设置参数，有驱动，url，用户，密码，因为由数据库连接池来管理链接，它需要有所有的参数信息
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);


        // 设置连接池的初始化链接个数，和最大链接个数
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);


        System.out.println("program start...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("total time: " + (end - start));
    }

    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_edu");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
        System.out.println("connect success...");
    }
}
