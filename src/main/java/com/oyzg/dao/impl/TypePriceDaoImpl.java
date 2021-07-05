package com.oyzg.dao.impl;

import com.oyzg.dao.TypePriceDao;
import com.oyzg.pojo.TypePrice;

import java.util.List;

public class TypePriceDaoImpl extends BaseDao implements TypePriceDao {
    @Override
    public TypePrice queryByType(String typeName) {
        String sql = "select * from typeprice where tname = ?";
        return queryForOne(TypePrice.class, sql, typeName);
    }

    @Override
    public TypePrice queryById(Integer id) {
        String sql = "select * from typeprice where tid = ?";
        return queryForOne(TypePrice.class, sql,id);
    }

    @Override
    public List<TypePrice> queryAll() {
        String sql = "select * from typeprice";
        return queryForList(TypePrice.class, sql);
    }

    @Override
    public void add(TypePrice typePrice) {
        String sql = "insert into typeprice values (null,?,?)";
        update(sql,typePrice.getTname(),typePrice.getUnitprice());
    }

    @Override
    public void update(TypePrice typePrice) {
        String sql = "update typeprice set tname = ?, unitprice = ? where tid = ?";
        update(sql, typePrice.getTname(),typePrice.getUnitprice(),typePrice.getTid());
    }

    @Override
    public void dalete(Integer id) {
        String sql = "delete from typeprice where tid = ?";
        update(sql, id);
    }
}
