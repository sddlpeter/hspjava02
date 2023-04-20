package com.hspedu.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// 使用apache dbutils 工具类 +druid完成对表的crud操作
public class Apache_DBUtils_Use {
    @Test
    public void testQueryMany() throws SQLException {
        // 1. 得到链接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用dbutils类和接口，先引入jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id, name, sex, phone from actor where id >= ?";

        // 3. query方法就是执行sql语句，得到resultSet，然后封装到arrayList集合中
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        for (Actor actor : list) {
            System.out.println(actor);
        }

        JDBCUtilsByDruid.close(null, null, connection);

    }


    @Test
    public void testQuerySingle() throws SQLException {
        // 1. 得到链接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用dbutils类和接口，先引入jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id, name, sex, phone from actor where id = ?";

        // 3. query方法就是执行sql语句，得到resultSet，然后封装到arrayList集合中
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 10);
        System.out.println(actor);

        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testQueryScalar() throws SQLException {
        // 1. 得到链接
        Connection connection = JDBCUtilsByDruid.getConnection();
        // 2. 使用dbutils类和接口，先引入jar文件
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";

        // 3. query方法就是执行sql语句，得到resultSet，然后封装到arrayList集合中
        Object query = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(query);

        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into actor values (null, ?, ?, ?, ?)";
        String sql2 = "update actor set name = ? where id = ?";
        String sql3 = "delete from actor where id = ?";
        int affectedRows = queryRunner.update(connection, sql3, 4);
        System.out.println("affected rows: " + affectedRows);
    }
}
