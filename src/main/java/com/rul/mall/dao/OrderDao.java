package com.rul.mall.dao;


import com.rul.mall.bean.Order;

import java.util.HashMap;

/**
 *  @author: Luoru
 *  @Date: 2019/10/19 3:52
 *  @Description: 操作Order表的DAO
 */
public interface OrderDao {

    /**
     * 创建订单
     *
     * @param order Order对象
     * @time 2019年10月13日11:31:20
     */
    void createOrder(Order order);

    /**
     * 删除订单
     *
     * @param orderId 待删除的订单Id
     * @return 影响的数据条数
     * @time 2019年10月10日03:44:57
     */
    int deleteOrder(String orderId);

    /**
     * 查询用户的订单信息
     *
     * @param userId 用户Id
     * @return 该用户的订单
     * @time 2019年10月9日03:51:39
     */
    HashMap<String, Order> selectInformation(String userId);

}
