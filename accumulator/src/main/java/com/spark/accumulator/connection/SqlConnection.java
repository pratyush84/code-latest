package com.spark.accumulator.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class   SqlConnection {
    private static Connection con;

    private SqlConnection() {
    }

    private static Connection createSqlConnection() throws Exception {
        HikariDataSource hikariDataSource = null;
        Sql2o sql2o;


        try {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/crds");
            config.setUsername("root");
//            config.setPassword(password);
            hikariDataSource = new HikariDataSource(config);
            sql2o = new Sql2o(hikariDataSource);
            con = sql2o.open();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return con;

    }

    public static Connection getSqlConnection() throws Exception {
        if (null == con) {
            createSqlConnection();
        }
        return con;
    }

}

