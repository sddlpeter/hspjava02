package com.hspedu.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class TestConn {
    @Test
    public void testConnection() {

        System.out.println("program start...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
        System.out.println("program end...");
    }
}
