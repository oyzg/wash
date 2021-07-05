package com.oyzg.service;

import com.oyzg.pojo.Assistant;
import com.oyzg.pojo.Clothes;
import com.oyzg.pojo.Member;

import java.util.List;

public interface ClothesService {

    public Clothes findByCId(Integer cId);

    public List<Clothes> findByMId(Integer mid);

    public List<Clothes> findByTId(Integer tId);

    public List<Clothes> findByAId(Assistant assistant);

    public List<Clothes> queryAll();

    void update(Clothes clothes);

    void delete(Integer cid);

    void add(Clothes clothes);

    Clothes findBycId(Integer cid);

    List<Clothes> findByDate(String date);
}
