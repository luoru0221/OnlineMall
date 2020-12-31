package com.rul.mall.dao.impl;


import com.rul.mall.bean.Cart;
import com.rul.mall.bean.Product;
import com.rul.mall.dao.CartDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDaoImpl extends DbUtil implements CartDao {

    @Override
    public ArrayList<Product> selectCartByUserId(String uid) {
        String sql = "SELECT product.id,product.image,product.name,cart.number,product.price FROM CART , PRODUCT WHERE cart.uid = ? AND product.id = cart.pid";
        ResultSet resultSet = this.doQuery(sql, new Object[]{uid});
        Product product;
        ArrayList<Product> productCart = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int pid = resultSet.getInt("product.id");
                String image = resultSet.getString("product.image");//商品图片
                String name = resultSet.getString("product.name"); //商品名称
                int number = resultSet.getInt("cart.number");  //商品数量
                double price = resultSet.getDouble("product.price");  //商品单价
                product = new Product();
                product.setId(pid);
                product.setImage(image);
                product.setName(name);
                product.setPrice(price);
                product.setNumber(number);
                productCart.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return productCart;
    }

    @Override
    public int selectCartNumber(String uid) {
        String sql = "SELECT pid FROM cart WHERE uid = ?";
        int number = 0;
        ResultSet resultSet = this.doQuery(sql, new Object[]{uid});
        try {
            while (resultSet.next()) {
                number++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return number;
    }

    @Override
    public int selectProductNumber(Cart cart) {
        String sql = "SELECT number FROM cart WHERE uid = ? AND pid = ?";
        ResultSet resultSet = this.doQuery(sql, new Object[]{cart.getUid(), cart.getPid()});
        try {
            if (resultSet.next()) {
                return resultSet.getInt("number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return 0;
    }

    @Override
    public boolean addCart(Cart cart) {
        int number = selectProductNumber(cart);
        try {
            if (number == 0) {
                String sql = "INSERT INTO cart (uid,pid,number,type) VALUES (?,?,?,?)";
                Object[] params = {cart.getUid(), cart.getPid(), cart.getNumber(), cart.getType()};
                this.doUpdate(sql, params);
                return true;
            } else {
                String sql = "UPDATE cart SET number = ? WHERE uid = ? AND pid = ?";
                Object[] params = {number + cart.getNumber(), cart.getUid(), cart.getPid()};
                this.doUpdate(sql, params);
                return false;
            }
        } finally {
            this.close();
        }
    }

    @Override
    public int addCartTemp(Cart cart) {
        String sql = "INSERT INTO cart (uid,pid,number,type) VALUES (?,?,?,?)";
        Object[] params = {cart.getUid(), cart.getPid(), cart.getNumber(), cart.getType()};
        return this.doUpdate(sql, params);
    }

    @Override
    public void deleteCart(Cart cart) {
        String sql = "DELETE FROM cart WHERE uid=? AND pid=?";
        Object[] params = {cart.getUid(), cart.getPid()};
        try {
            this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public void deleteCartTemp(String uid) {
        String sql = "DELETE FROM cart WHERE uid=? AND type=1";
        try {
            this.doUpdate(sql, new Object[]{uid});
        } finally {
            this.close();
        }
    }

    @Override
    public int updateCart(Cart cart) {
        String sql = "UPDATE cart SET number=?,type=? WHERE uid=? AND pid=?";
        Object[] params = {cart.getNumber(), cart.getType(), cart.getUid(), cart.getPid()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    @Override
    public ArrayList<Product> selectToOrderCart(String uid) {
        String sql = "SELECT product.id,product.image,product.name,cart.number,product.price FROM CART , PRODUCT WHERE cart.uid = ? AND product.id = cart.pid AND cart.type = 1";
        ResultSet resultSet = this.doQuery(sql, new Object[]{uid});
        Product product;
        ArrayList<Product> productCart = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int pid = resultSet.getInt("product.id");
                String image = resultSet.getString("product.image");//商品图片
                String name = resultSet.getString("product.name"); //商品名称
                int number = resultSet.getInt("cart.number");  //商品数量
                double price = resultSet.getDouble("product.price");  //商品单价
                product = new Product();
                product.setId(pid);
                product.setImage(image);
                product.setName(name);
                product.setPrice(price);
                product.setNumber(number);
                productCart.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return productCart;
    }

    @Override
    public void refreshCart(String uid) {
        String sql = "UPDATE CART SET type=0 WHERE uid=? and type=1";
        try {
            this.doUpdate(sql, new Object[]{uid});
        } finally {
            this.close();
        }
    }
}
