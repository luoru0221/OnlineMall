package com.rul.mall.bean;

import java.util.ArrayList;

/**
 *  @author: Luoru
 *  @Date: 2019/10/19 3:39
 *  @Description: 分类
 */
public class Type {
    private int id;  //id
    private int fid;  //父级分类id
    private String name;  //分类名称
    private ArrayList<Type> cTypes;  //子分类

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Type> getcTypes() {
        return cTypes;
    }

    public void setcTypes(ArrayList<Type> cTypes) {
        this.cTypes = cTypes;
    }
}
