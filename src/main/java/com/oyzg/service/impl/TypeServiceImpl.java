package com.oyzg.service.impl;

import com.oyzg.dao.TypePriceDao;
import com.oyzg.dao.impl.TypePriceDaoImpl;
import com.oyzg.pojo.TypePrice;
import com.oyzg.service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    private TypePriceDao typePriceDao = new TypePriceDaoImpl();

    @Override
    public List<TypePrice> findAll() {
        return typePriceDao.queryAll();
    }

    @Override
    public TypePrice findByid(Integer id) {
        return typePriceDao.queryById(id);
    }

    @Override
    public TypePrice findByType(String typeName) {
        return typePriceDao.queryByType(typeName);
    }

    @Override
    public void add(TypePrice typePrice) {
        typePriceDao.add(typePrice);
    }

    @Override
    public void update(TypePrice typePrice) {
        typePriceDao.update(typePrice);
    }

    @Override
    public void delete(Integer id) {
        typePriceDao.dalete(id);
    }
}
