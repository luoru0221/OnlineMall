package com.rul.mall.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 执行查询语句，返回查询到的结果集
     */
    protected ResultSet doQuery(String sql, Object[] params) {
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if(params!=null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 执行更新语句，数据库的增、删和改，返回受影想的数据条数
     */
    protected int doUpdate(String sql, Object[] params) {
        int number = 0;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (params!=null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            //受影响的数据条数
            number = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    /**
     * 释放资源
     */
    protected void close(){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement=null;
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }
    }

}
