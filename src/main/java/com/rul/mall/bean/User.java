package com.rul.mall.bean;

/**
 *  @author: Luoru
 *  @Date: 2019/10/19 3:39
 *  @Description: 用户
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String address; //地址
    private int type;  //类别（0管理员  1商家  2顾客）
    private String recName;

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User(){}

    
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }
    public User(String id, String name, String password , String email){
        this(id,password);
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
