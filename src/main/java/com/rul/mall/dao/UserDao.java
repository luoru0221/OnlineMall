package com.rul.mall.dao;


import com.rul.mall.bean.User;

import java.util.ArrayList;

public interface UserDao {

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return User对象，没查询到时返回null
     */
    User queryUserById(String id);

    /**
     * 添加用户
     * @param newUser 需添加的User对象
     * @return 影响的数据条数
     */
    int addUser(User newUser);

    /**
     * 根据id删除用户
     * @param id 待删除的用户id
     * @return 影响的数据条数
     */
    int deleteUserById(String id);//根据Id删除User

    /**
     * 修改收件人信息
     * @param user User对象，包含用户的收件人姓名和地址
     * @return 影响数据的条数
     */
    int updateUserAddress(User user);

    /**
     * 修改用户密码
     * @param user User对象，包含用户ID和密码
     * @return 影响数据的条数
     */
    int updateUserPwd(User user);// 修改用户密码


    /**
     * @return 除后台管理员之外的所有User对象的ArrayList集合
     * @time 2019年10月10日20:20:11
     */
    ArrayList<User> queryAllUsers();

    void updateUserType(User user);

    ArrayList<User> searchLikeUsers(String keyword);
}
