package com.hspedu.jdbc;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1. 加载驱动
        Driver driver = new Driver();
        // (1) jdbc:mysql: 通过jdbc的方式链接到mysql
        // (2) localhost 主机，也可以使用ip
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "neu05317X@");
        // 2. 获取链接
        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsp_db02", "root", "neu05317X@");
        Connection connection = driver.connect(url, info);

        // 3. 执行增删改查
        String sql = "insert into actor values (null, 'Alice', 'F', '1998-1-1', '110')";

        Statement statement = connection.createStatement();
        int update = statement.executeUpdate(sql);
        System.out.println(update > 0 ? "success" : "failure");

        // 4. 关闭链接
        statement.close();
        connection.close();
    }
}
