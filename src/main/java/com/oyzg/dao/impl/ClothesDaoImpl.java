package com.oyzg.dao.impl;

import com.oyzg.dao.ClothesDao;
import com.oyzg.pojo.Clothes;

import java.util.List;

public class ClothesDaoImpl extends BaseDao implements ClothesDao {
    @Override
    public Clothes queryByCId(Integer cId) {
        String sql = "select * from clothes where cid = ?";
        return queryForOne(Clothes.class, sql, cId);
    }


    @Override
    public List<Clothes> queryByMId(Integer mId) {
        String sql = "select * from clothes where mid = ?";
        return queryForList(Clothes.class, sql, mId);
    }

    @Override
    public List<Clothes> queryByTId(Integer tId) {
        String sql = "select * from clothes where tid = ?";
        return queryForList(Clothes.class, sql, tId);
    }

    @Override
    public List<Clothes> queryByAId(Integer aId) {
        String sql = "select * from clothes where aid = ?";
        return queryForList(Clothes.class, sql, aId);
    }

    @Override
    public List<Clothes> queryAll() {
        String sql = "select * from clothes";
        return queryForList(Clothes.class, sql);
    }

    @Override
    public void update(Clothes clothes) {
        String sql = "update clothes set ccount = ?, mid = ?, aid = ?, date = ?, tid = ? where cid = ?";
        update(sql,clothes.getCcount(),clothes.getMid(),clothes.getAid(),clothes.getDate(),clothes.getTid(),clothes.getCid());
    }

    @Override
    public void delete(Integer cid) {
        String sql = "delete from clothes where cid = ?";
        update(sql,cid);
    }

    @Override
    public void add(Clothes clothes) {
        String sql = "insert into clothes values (null,?,?,?,?,?)";
        update(sql,clothes.getCcount(),clothes.getMid(),clothes.getAid(),clothes.getDate(),clothes.getTid());
    }

    @Override
    public List<Clothes> queryByDate(String date) {
        String sql = "select * from clothes where date = ?";
        return queryForList(Clothes.class, sql, date);
    }
}
