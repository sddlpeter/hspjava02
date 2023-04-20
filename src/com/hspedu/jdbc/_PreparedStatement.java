package com.hspedu.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _PreparedStatement {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
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

        String sql = "select username, password from admin where username=? and password = ?";

        Connection connection = DriverManager.getConnection(url, user, psd);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_psd);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String u = resultSet.getString(1);
            String p = resultSet.getString(2);
            System.out.println("user: " + u + " password: " + p);
        }

        preparedStatement.close();
        connection.close();


    }
}
