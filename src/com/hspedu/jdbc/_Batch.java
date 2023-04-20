package com.hspedu.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _Batch {

    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("start running...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "Jack" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
        //total: 9633

        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("start running...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "Jack" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.addBatch();
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                // clear batch
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));

        JDBCUtils.close(null, preparedStatement, connection);
    }
}
