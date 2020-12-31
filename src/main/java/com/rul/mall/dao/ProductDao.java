package com.rul.mall.dao;


import com.rul.mall.bean.Product;

import java.util.ArrayList;

public interface ProductDao {

    /**
     * 根据id查找商品
     *
     * @param id 商品id
     * @return 查找到的Product对象
     */
    Product queryProductById(int id);

    /**
     * 添加商品
     *
     * @param product 需加入的Product对象
     */
    void addProduct(Product product);

    /**
     * 查找某种类的所有商品
     *
     * @param type 分类id
     * @return 该分类的所有商品
     */
    ArrayList<Product> queryProductByType(int type);

    /**
     * 查询某店铺的所有商品
     *
     * @param store 店铺id
     * @return 该店铺的所有商品
     */
    ArrayList<Product> queryProductByStore(String store);

    /**
     * 查询所有商品
     *
     * @return 所有商品的ArrayList集合
     */
    ArrayList<Product> queryAllProducts();

    /**
     * 删除商品
     *
     * @param productId 待删除的商品id
     * @return 影响的数据条数
     */
    int deleteProduct(int productId);

    /**
     * 修改商品信息
     *
     * @param product 新的商品信息
     */
    void updateProduct(Product product);

    /**
     * 模糊搜索商品
     *
     * @param keyword 搜索关键字
     * @return 搜索到的所有Product的ArrayList集合
     */
    ArrayList<Product> selectLikeProduct(String keyword);

    /**
     * 模糊搜索之指定数量的商品
     *
     * @param keyword 搜索关键字
     * @param page    页码
     * @param number  每页的展示的商品数
     * @return Product集合
     */
    ArrayList<Product> selectLikeProductLimit(String keyword, int page, int number);

    /**
     * 分类查找所有商品并分页
     *
     * @param typeId 分类id
     * @param page   页码
     * @param number 每页展示的数量
     * @return Product集合
     */
    ArrayList<Product> selectTypeProductLimit(int typeId, int page, int number);
}
