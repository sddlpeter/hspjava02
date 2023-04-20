package com.hspedu.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _PreparedStatement02 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入管理员用户名：");
        String admin_name = scanner.nextLine();
        System.out.println("请输入管理员密码：");
        String admin_psd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/info.properties"));
        String user = properties.getProperty("user");
        String psd = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class<?> cls = Class.forName(driver);
        Driver dr = (Driver) cls.newInstance();
        DriverManager.registerDriver(dr);

        System.out.println("no problem here...");

        String sql = "insert into admin values (?, ?)";

        Connection connection = DriverManager.getConnection(url, user, psd);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_psd);
        int i = preparedStatement.executeUpdate();

        System.out.println(i > 0 ? "success" : "failed");

        preparedStatement.close();
        connection.close();
    }
}
