package com.rul.mall.dao;


import com.rul.mall.bean.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: Luoru
 * @Date: 2019/10/13 19:08
 * @Description: OrderItem数据库操作
 */
public interface OrderItemDao {

    /**
     * 创建订单项
     *
     * @param orderItem OrderItemd对象
     * @time 2019年10月13日11:56:42
     */
    void createOrderItem(OrderItem orderItem);

    /**
     * 删除订单项
     *
     * @param orderItem 待删除的OrderItem对象
     * @return 影响的暑假条数
     * @time 2019年10月13日19:07:54
     */
    int delateOrderItem(OrderItem orderItem);

    /**
     * 查询某一用户的所有订单
     *
     * @param uid 需查询的用户Id
     * @return 该用户的订单HashMap<String, ArrayList < OrderItem>>集合
     * @time 2019年10月13日20:57:58
     */
    HashMap<String, ArrayList<OrderItem>> selectAllOrdersByUserId(String uid);

    /**
     * 查询某一店家的所有订单号
     *
     * @param store 店铺id，店家的账号
     * @return 该店家的订单的HashMap<String, ArrayList < OrderItem>>集合
     * @time 2019年10月14日20:44:28
     */
    HashMap<String, ArrayList<OrderItem>> selectAllOrdersByStore(String store);

    /**
     * 修改订单项的状态
     *
     * @param orderItem 需更改的订单项
     * @return 更改的数据条数
     * @time 2019年10月14日04:04:29
     */
    int updateOrderItemType(OrderItem orderItem);

    /**
     * 查找所有的订单
     *
     * @author: Luoru
     * @Date: 2019/10/16 1:02
     */
    HashMap<String, ArrayList<OrderItem>> selectAllOrder();


}
