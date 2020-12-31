package com.rul.mall.bean;

/**
 *  @author: Luoru
 *  @Date: 2019/10/19 3:38
 *  @Description: 商品
 */
public class Product {
    private int id; //商品id
    private String name; //商品名称
    private String description;  //商品描述
    private double price;  //商品价格
    private String image; //商品图片
    private int type; //商品类别
    private int number;//商品数量
    private String store; //商品所属店铺

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Product(){}
    public Product(int id, String name, String description, double price, String image, int type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public int getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
