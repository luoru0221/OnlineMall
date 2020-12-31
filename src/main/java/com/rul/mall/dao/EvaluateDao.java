package com.rul.mall.dao;


import com.rul.mall.bean.Evaluate;

import java.util.ArrayList;

/**
 *  @author: Luoru
 *  @Date: 2019/10/19 3:52
 *  @Description: 操作EvaluateDao表的DAO
 */
public interface EvaluateDao {

    /**
     * 查询商品评价
     *
     * @param pid 商品id
     * @return 该商品的所有评价
     * @time 2019年10月10日15:40:34
     */
    ArrayList<Evaluate> selectEvaluatesByPid(int pid);

    /**
     * 添加商品评价
     *
     * @param evaluate 待添加的Evaluate对象
     * @return 影响的数据条数
     * @time 2019年10月19日03:40:55
     */
    int addEvaluateForProduct(Evaluate evaluate);

}
