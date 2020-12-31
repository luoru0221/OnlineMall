package com.rul.mall.dao.impl;


import com.rul.mall.bean.Evaluate;
import com.rul.mall.dao.EvaluateDao;
import com.rul.mall.utils.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EvaluateDaoImpl extends DbUtil implements EvaluateDao {
    @Override
    public ArrayList<Evaluate> selectEvaluatesByPid(int pid) {
        ArrayList<Evaluate> evaluates = new ArrayList<>();
        Evaluate evaluate;
        String sql = "SELECT * FROM EVALUATE WHERE pid = ?";
        try {
            ResultSet resultSet = this.doQuery(sql, new Object[]{pid});
            while(resultSet.next()){
                evaluate = new Evaluate();
                setEvaluate(resultSet,evaluate);
                evaluates.add(evaluate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return evaluates;
    }

    @Override
    public int addEvaluateForProduct(Evaluate evaluate) {
        String sql = "INSERT INTO EVALUATE (pid,uid,content,time) VALUES (?,?,?,?)";
        Object[] params = {evaluate.getPid(),evaluate.getUid(),evaluate.getContent(),evaluate.getTime()};
        try {
            return this.doUpdate(sql, params);
        } finally {
            this.close();
        }
    }

    private void setEvaluate(ResultSet resultSet, Evaluate evaluate) throws SQLException {
        evaluate.setId(resultSet.getInt("id"));
        evaluate.setPid(resultSet.getInt("pid"));
        evaluate.setUid(resultSet.getString("uid"));
        evaluate.setContent(resultSet.getString("content"));
        evaluate.setTime(resultSet.getString("time"));
    }
}
