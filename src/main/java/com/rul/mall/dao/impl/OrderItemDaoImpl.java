package com.rul.mall.dao.impl;


import com.rul.mall.bean.OrderItem;
import com.rul.mall.bean.Product;
import com.rul.mall.dao.OrderItemDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderItemDaoImpl extends DbUtil implements OrderItemDao {

    @Override
    public void createOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO orderitem (oid,pid,number,type) values(?,?,?,?)";
        Object[] params = {orderItem.getOid(), orderItem.getPid(), orderItem.getNumber(), orderItem.getType()};
        try {
            this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public int delateOrderItem(OrderItem orderItem) {
        String sql = "DELETE FROM orderitem WHERE oid=?";
        try {
            return this.doUpdate(sql,new Object[]{orderItem.getOid()});
        } finally {
            this.close();
        }
    }


    @Override
    public HashMap<String, ArrayList<OrderItem>> selectAllOrdersByUserId(String uid) {
        HashMap<String, ArrayList<OrderItem>> allOrders = new HashMap<>();
        ArrayList<OrderItem> orderItems;
        OrderItem orderItem;
        Product product;
        String sql = "SELECT orders.id,product.id,product.name,product.price,orderitem.number,product.image," +
                "orderitem.type FROM ORDERS,ORDERITEM,PRODUCT WHERE orders.uid = ? and orders.id = orderitem." +
                "oid and orderitem.pid = product.id";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{uid});
            while (resultSet.next()) {
                String orderId = resultSet.getString("orders.id");
                int productId = resultSet.getInt("product.id");
                String productName = resultSet.getString("product.name");
                double productPrice = resultSet.getDouble("product.price");
                String productImage = resultSet.getString("product.image");
                int productNumber = resultSet.getInt("orderitem.number");
                int orderItemType = resultSet.getInt("orderitem.type");

                if (!allOrders.containsKey(orderId)) {
                    orderItems = new ArrayList<>();
                    allOrders.put(orderId, orderItems);
                }
                product = new Product();
                product.setId(productId);
                product.setName(productName);
                product.setPrice(productPrice);
                product.setImage(productImage);

                orderItem = new OrderItem();
                orderItem.setOid(orderId);
                orderItem.setPid(productId);
                orderItem.setType(orderItemType);
                orderItem.setNumber(productNumber);
                orderItem.setProduct(product);

                allOrders.get(orderId).add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return allOrders;
    }

    @Override
    public HashMap<String, ArrayList<OrderItem>> selectAllOrdersByStore(String store) {
        HashMap<String, ArrayList<OrderItem>> allOrders = new HashMap<>();
        ArrayList<OrderItem> orderItems;
        OrderItem orderItem;
        Product product;
        String sql = "SELECT orders.id,orderitem.pid,orderitem.number,orderitem.type,product.name," +
                "product.price,product.image FROM PRODUCT,ORDERS,ORDERITEM WHERE product.store=? and product.id=" +
                "orderitem.pid and orderitem.oid=orders.id";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{store});
            while (resultSet.next()) {
                String orderId = resultSet.getString("orders.id");
                int productId = resultSet.getInt("orderitem.pid");
                int productNumber = resultSet.getInt("orderitem.number");
                int orderItemType = resultSet.getInt("orderitem.type");
                String productName = resultSet.getString("product.name");
                double productPrice = resultSet.getDouble("product.price");
                String productImage = resultSet.getString("product.image");

                //该订单号还不存在
                if (!allOrders.containsKey(orderId)) {
                    orderItems = new ArrayList<>();
                    allOrders.put(orderId, orderItems);
                }
                product = new Product();
                product.setId(productId);
                product.setName(productName);
                product.setPrice(productPrice);
                product.setImage(productImage);

                orderItem = new OrderItem();
                orderItem.setOid(orderId);
                orderItem.setType(orderItemType);
                orderItem.setNumber(productNumber);
                orderItem.setPid(productId);
                orderItem.setProduct(product);

                allOrders.get(orderId).add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return allOrders;
    }

    @Override
    public int updateOrderItemType(OrderItem orderItem) {
        String sql = "UPDATE ORDERITEM SET type=? WHERE oid=? and pid=?";
        Object[] params = {orderItem.getType(), orderItem.getOid(), orderItem.getPid()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public HashMap<String, ArrayList<OrderItem>> selectAllOrder() {
        HashMap<String, ArrayList<OrderItem>> allOrders = new HashMap<>();
        ArrayList<OrderItem> orderItems;
        OrderItem orderItem;
        Product product;
        String sql = "SELECT orders.id,orderitem.pid,orderitem.number,orderitem.type,product.name," +
                "product.price,product.image FROM PRODUCT,ORDERS,ORDERITEM WHERE product.id=" +
                "orderitem.pid and orderitem.oid=orders.id";
        try {
            ResultSet resultSet = this.doQuery(sql, null);
            while (resultSet.next()) {
                String orderId = resultSet.getString("orders.id");
                int productId = resultSet.getInt("orderitem.pid");
                int productNumber = resultSet.getInt("orderitem.number");
                int orderItemType = resultSet.getInt("orderitem.type");
                String productName = resultSet.getString("product.name");
                double productPrice = resultSet.getDouble("product.price");
                String productImage = resultSet.getString("product.image");

                //该订单号还不存在
                if (!allOrders.containsKey(orderId)) {
                    orderItems = new ArrayList<>();
                    allOrders.put(orderId, orderItems);
                }
                product = new Product();
                product.setId(productId);
                product.setName(productName);
                product.setPrice(productPrice);
                product.setImage(productImage);

                orderItem = new OrderItem();
                orderItem.setOid(orderId);
                orderItem.setType(orderItemType);
                orderItem.setNumber(productNumber);
                orderItem.setPid(productId);
                orderItem.setProduct(product);

                allOrders.get(orderId).add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return allOrders;
    }
}