package com.rul.mall.dao.impl;


import com.rul.mall.bean.Order;
import com.rul.mall.dao.OrderDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.util.HashMap;

public class OrderDaoImpl extends DbUtil implements OrderDao {
    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (id,uid,price,address,name) VALUES (?,?,?,?,?)";
        Object[] params = {order.getId(), order.getUid(), order.getPrice(), order.getAddress(), order.getName()};
        try {
            this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int deleteOrder(String orderId) {
        String sql = "DELETE FROM orders WHERE id=?";
        try {
            return this.doUpdate(sql, new Object[]{orderId});
        } finally {
            this.close();
        }
    }

    @Override
    public HashMap<String, Order> selectInformation(String userId) {
        HashMap<String, Order> infor = new HashMap<>();
        String sql = "SELECT orders.id,orders.address,orders.name from orders,product,orderitem where product.store = ? and product.id=orderitem.pid and orderitem.oid = orders.id";
        ResultSet resultSet = this.doQuery(sql, new Object[]{userId});
        try {
            while (resultSet.next()) {
                Order order = new Order();
                order.setAddress(resultSet.getString("orders.address"));
                order.setName(resultSet.getString("orders.name"));
                infor.put(resultSet.getString("orders.id"), order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return infor;
    }

}
