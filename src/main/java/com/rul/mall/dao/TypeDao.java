package com.rul.mall.dao;


import com.rul.mall.bean.Type;

import java.util.ArrayList;

public interface TypeDao {
    /**
     * @param type 添加的分类
     * @return 影响的数据条数
     * @time 2019年10月16日16:40:12
     */
    int addType(Type type);

    /**
     * 查询所有的分类信息
     *
     * @param allTypes 查询的结果
     * @param fId      根据父分类Id查询
     */
    void selectAllType(ArrayList<Type> allTypes, int fId);

    /**
     * @return 某一分类的所有子分类对象
     * @time 2019年10月16日17:42:31
     */
    ArrayList<Type> selectChildrenTypes(int fid);

    /**
     * 查找某一分类的同级分类
     *
     * @param id 分类ID
     * @return 该分类的全部同级分类
     * @time 2019年10月18日19:51:37
     */
    ArrayList<Type> selectSlibingTypes(int id);

    /**
     * 查找父级分类
     *
     * @param id 分类ID
     * @return 父级分类
     * @time 2019年10月18日20:04:54
     */
    Type selectFatherType(int id);

    /**
     * 修改分类的名称
     *
     * @param type 待修改id分类
     * @time 2019年10月20日13:02:27
     */
    void updateTypeName(Type type);
}
