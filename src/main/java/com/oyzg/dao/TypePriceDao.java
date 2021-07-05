package com.oyzg.dao;

import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;

import java.util.List;

public interface TypePriceDao {

    public TypePrice queryByType(String typeName);

    public TypePrice queryById(Integer id);

    public List<TypePrice> queryAll();

    void add(TypePrice typePrice);

    void update(TypePrice typePrice);

    void dalete(Integer id);
}
