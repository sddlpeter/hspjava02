package com.hspedu.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils_Use {
    public static void main(String[] args) {

    }

    @Test
    public void testDML() {
        Connection connection = null;
        String sql = "update admin set password = ? where username = ?";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "123456789");
            preparedStatement.setString(2, "Mary");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
