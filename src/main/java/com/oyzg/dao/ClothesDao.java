package com.oyzg.dao;

import com.oyzg.pojo.Clothes;

import java.util.List;

public interface ClothesDao {

    public Clothes queryByCId(Integer cId);

    public List<Clothes> queryByMId(Integer mId);

    public List<Clothes> queryByTId(Integer tId);

    public List<Clothes> queryByAId(Integer aId);

    public List<Clothes> queryAll();

    void update(Clothes clothes);

    void delete(Integer cid);

    void add(Clothes clothes);

    List<Clothes> queryByDate(String date);
}

