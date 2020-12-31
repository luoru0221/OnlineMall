package com.rul.mall.bean;

/**
 * @author: Luoru
 * @Date: 2019/10/19 3:36
 * @Description: 购物车
 */
public class Cart {
    private String uid;
    private int pid;
    private int number;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
