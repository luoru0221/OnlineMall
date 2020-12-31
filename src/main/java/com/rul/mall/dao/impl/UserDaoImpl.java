package com.rul.mall.dao.impl;


import com.rul.mall.bean.User;
import com.rul.mall.dao.UserDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl extends DbUtil implements UserDao {

    @Override
    public User queryUserById(String id) {
        User user = null;
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        ResultSet resultSet = this.doQuery(sql, new Object[]{id});
        try {
            if (resultSet.next()) {
                user = new User();
                setUser(resultSet, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return user;
    }

    @Override
    public int addUser(User newUser) {
        try {
            String sql = "INSERT INTO USERS (id,name,password,email) VALUES (?,?,?,?)";
            Object[] params = {newUser.getId(), newUser.getName(), newUser.getPassword(), newUser.getEmail()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int deleteUserById(String id) {
        String sql = "DELETE FROM USERS WHERE id = ?";
        try {
            return this.doUpdate(sql, new Object[]{id});
        } finally {
            this.close();
        }
    }

    @Override
    public int updateUserPwd(User user) {
        try {
            String sql = "UPDATE users set password=? WHERE id=?";
            Object[] params = {user.getPassword(), user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int updateUserAddress(User user) {
        try {
            String sql = "UPDATE users SET recname = ?,address = ? WHERE id = ?";
            Object[] params = {user.getRecName(), user.getAddress(), user.getId()};
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public ArrayList<User> queryAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user;
        String sql = "SELECT * FROM USERS WHERE type <> 0";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while (resultSet.next()) {
                user = new User();
                setUser(resultSet, user);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return users;
    }

    @Override
    public void updateUserType(User user) {
        String sql = "UPDATE USERS set type = ? Where id = ?";
        Object[] params = {user.getType(), user.getId()};
        try {
            this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public ArrayList<User> searchLikeUsers(String keyword) {
        ArrayList<User> users = new ArrayList<>();
        String sql = "select * from users where id like '%"+keyword+"%' or name like '%"+keyword+"%'";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while(resultSet.next()){
                User user = new User();
                setUser(resultSet,user);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return users;
    }

    /**
     * @param resultSet 数据库返回的所有User对象的结果集
     * @param user      需设置属性值的User对象
     * @time 2019年10月10日20:36:33
     */
    private void setUser(ResultSet resultSet, User user) throws SQLException {
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setAddress(resultSet.getString("address"));
        user.setType(resultSet.getInt("type"));
        user.setRecName(resultSet.getString("recname"));
    }
}
