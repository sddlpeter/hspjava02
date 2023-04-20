package com.hspedu.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _Transaction {
    @Test
    public void noTransaction() {
        Connection connection = null;
        String sql1 = "update account set balance = balance - 100 where id = 2";
        String sql2 = "update account set balance = balance + 100 where id = 3";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void useTransaction() throws SQLException {
        Connection connection = null;
        String sql1 = "update account set balance = balance - 100 where id = 2";
        String sql2 = "update account set balance = balance + 100 where id = 3";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);


            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            // int i = 1 / 0;

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            connection.rollback();
            System.out.println("roll back");
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
