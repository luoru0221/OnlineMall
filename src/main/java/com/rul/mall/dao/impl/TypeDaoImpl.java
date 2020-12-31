package com.rul.mall.dao.impl;


import com.rul.mall.bean.Type;
import com.rul.mall.dao.TypeDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDaoImpl extends DbUtil implements TypeDao {
    @Override
    public int addType(Type type) {
        String sql = "INSERT INTO productType (fid,name) values(?,?)";
        Object[] params = {type.getFid(),type.getName()};
        try {
            return this.doUpdate(sql,params);
        } finally {
            this.close();
        }
    }

    @Override
    public void selectAllType(ArrayList<Type> allTypes, int fId) {
        String sql = "SELECT * FROM PRODUCTTYPE WHERE fid = ?";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{fId});
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int fid = resultSet.getInt("fid");
                String name = resultSet.getString("name");
                ArrayList<Type> children = new ArrayList<>();
                Type type = new Type();
                type.setId(id);
                type.setFid(fid);
                type.setName(name);
                type.setcTypes(children);
                allTypes.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            this.close();
        }
        for (Type allType : allTypes) {
            if(allType!=null){
                selectAllType(allType.getcTypes(),allType.getId());
            }
        }
    }


    @Override
    public ArrayList<Type> selectChildrenTypes(int fId) {
        String sql = "SELECT * FROM PRODUCTTYPE WHERE fid = ?";
        ArrayList<Type> childrenTypes = new ArrayList<>();
        ResultSet resultSet = this.doQuery(sql, new Object[]{fId});
        Type type;
        try {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int fid = resultSet.getInt("fid");
                String name = resultSet.getString("name");
                type = new Type();
                type.setId(id);
                type.setFid(fid);
                type.setName(name);

                childrenTypes.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return childrenTypes;
    }

    @Override
    public ArrayList<Type> selectSlibingTypes(int id) {
        String sql = "SELECT * FROM producttype WHERE id = ?";
        int fid = 0;
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{id});
            if(resultSet.next()){
                fid = resultSet.getInt("fid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return this.selectChildrenTypes(fid);
    }

    @Override
    public Type selectFatherType(int id) {
        String sql = "SELECT * FROM producttype WHERE id = ?";
        Type type = new Type();
        int fid = 0;
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{id});
            if(resultSet.next()){
                fid = resultSet.getInt("fid");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.close();
        }
        String sql2 = "SELECT * From producttype WHERE id = ?";
        try {
            ResultSet resultSet = this.doQuery(sql2, new Object[]{fid});
            if(resultSet.next()){
                int typeId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int fId = resultSet.getInt("fid");
                type.setId(typeId);
                type.setName(name);
                type.setFid(fId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return type;
    }

    @Override
    public void updateTypeName(Type type) {
        String sql = "update producttype set name=? where id=?";
        Object[] params = {type.getName(),type.getId()};
        try {
            this.doUpdate(sql,params);
        } finally {
            this.close();
        }
    }
}
