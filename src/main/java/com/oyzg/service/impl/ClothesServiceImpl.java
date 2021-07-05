package com.oyzg.service.impl;

import com.oyzg.dao.ClothesDao;
import com.oyzg.dao.impl.ClothesDaoImpl;
import com.oyzg.pojo.Assistant;
import com.oyzg.pojo.Clothes;
import com.oyzg.pojo.Member;
import com.oyzg.service.ClothesService;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {

    private ClothesDao clothesDao = new ClothesDaoImpl();

    @Override
    public Clothes findByCId(Integer cId) {
        return clothesDao.queryByCId(cId);
    }

    @Override
    public List<Clothes> findByMId(Integer mid ) {
        return clothesDao.queryByMId(mid);
    }

    @Override
    public List<Clothes> findByTId(Integer tId) {
        return clothesDao.queryByTId(tId);
    }

    @Override
    public List<Clothes> findByAId(Assistant assistant) {
        return clothesDao.queryByAId(assistant.getAid());
    }

    @Override
    public List<Clothes> queryAll() {
        return clothesDao.queryAll();
    }

    @Override
    public void update(Clothes clothes) {
        clothesDao.update(clothes);
    }

    @Override
    public void delete(Integer cid) {
        clothesDao.delete(cid);
    }

    @Override
    public void add(Clothes clothes) {
        clothesDao.add(clothes);
    }

    @Override
    public Clothes findBycId(Integer cid) {
        return clothesDao.queryByCId(cid);
    }

    @Override
    public List<Clothes> findByDate(String date) {
        return clothesDao.queryByDate(date);
    }
}
