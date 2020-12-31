package com.rul.mall.dao;


import com.rul.mall.bean.Cart;
import com.rul.mall.bean.Product;

import java.util.ArrayList;

/**
 *  @author: Luoru
 *  @Date: 2019/10/15 15:22
 *  @Description: 操作Cart数据表的DAO
 */
public interface CartDao {
    /**
     * 根据用户账号查询购物车
     *
     * @param uid 待查询的用户的购物车
     * @return Cart对象的ArrayLIst集合
     * @time 2019年10月13日19:10:25
     */
    ArrayList<Product> selectCartByUserId(String uid);//根据用户账号查询购物车

    /**
     * 查询用户的购物车的数量
     *
     * @param uid 用户账号
     * @return 该用户的所有购物车的数量
     * @time 2019年10月15日15:21:30
     */
    int selectCartNumber(String uid);//查询购物车数量

    /**
     * 查询购物车中的商品数量
     *
     * @param cart 待查询的Cart对象
     * @return 已经存在的购物车中商品的数量
     * @time 2019年10月15日15:21:51
     */
    int selectProductNumber(Cart cart);

    /**
     * 添加商品到购物车
     *
     * @param cart 待添加的Cart对象
     * @return 是否添加成功
     * @time 2019年10月15日15:13:22
     */
    boolean addCart(Cart cart); //添加购物车

    /**
     * 添加临时购物车
     *
     * @param cart 待添加的Cart对象
     * @return 影响的数据条数
     * @time 2019年10月15日15:14:37
     */
    int addCartTemp(Cart cart);

    /**
     * 删除购物车
     *
     * @param cart 待删除的Cart对象
     * @time 2019年10月15日15:16:05
     */
    void deleteCart(Cart cart);

    /**
     * 删除临时购物车
     *
     * @param uid 待删除临时购物车的用户账号
     * @time
     */
    void deleteCartTemp(String uid);

    /**
     * 更新购物车
     *
     * @param cart 新的购物车对象
     * @return 影响的数据条数
     * @time 2019年10月15日15:13:32
     */
    int updateCart(Cart cart);

    /**
     * 查询即将生成订单的购物车
     *
     * @param uid 用户Id
     * @return Product的ArrayList结果集
     * @time 2019年10月15日15:13:45
     */
    ArrayList<Product> selectToOrderCart(String uid);

    /**
     * 刷新购物车信息
     *
     * @param uid 待刷新购物车的用户账号
     * @time 2019年10月15日15:14:00
     */
    void refreshCart(String uid);

}
