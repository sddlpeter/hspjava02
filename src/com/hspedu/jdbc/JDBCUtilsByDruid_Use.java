package com.hspedu.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class JDBCUtilsByDruid_Use {
    public static void main(String[] args) {
        testSelectToArrayList();
    }

    public static void testDML() {
        Connection connection = null;
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your user id: ");
        String id = scanner.nextLine();
        int ids = Integer.parseInt(id);

        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ids);

            ResultSet resultSet = preparedStatement.executeQuery();
            // connection.close();

            while (resultSet.next()) {
                int actor_id = resultSet.getInt(1);
                String actor_name = resultSet.getString(2);
                String actor_gender = resultSet.getString(3);
                String actor_birth_date = resultSet.getString(4);
                System.out.println("user info: " + actor_id + "\t" +  actor_name + "\t" + actor_gender + "\t" + actor_birth_date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }
    }




    // 把结果集放到arrayList集合中
    public static void testSelectToArrayList() {
        Connection connection = null;
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your user id: ");
        String id = scanner.nextLine();
        int ids = Integer.parseInt(id);

        ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList<>();

        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ids);

            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int actor_id = resultSet.getInt(1);
                String actor_name = resultSet.getString(2);
                String actor_gender = resultSet.getString(3);
                Date actor_birth_date = resultSet.getDate(4);
                String actor_phone = resultSet.getString(5);
                list.add(new Actor(actor_id, actor_name, actor_gender, actor_birth_date, actor_phone));
                // System.out.println("user info: " + actor_id + "\t" +  actor_name + "\t" + actor_gender + "\t" + actor_birth_date + "\t" + actor_phone);
            }
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }
    }
}
