package com.rul.mall.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * 数据库连接工具
 */
class DbConnection {

    //数据库连接池对象
    private static DataSource dataSource;

    static{
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(Objects.requireNonNull(DbConnection.class.getClassLoader().getResourceAsStream("druid.properties")));
            //获得数据库连接对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库的连接
     */
    static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
