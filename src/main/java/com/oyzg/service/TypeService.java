package com.oyzg.service;

import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;

import java.util.List;

public interface TypeService {

    public List<TypePrice> findAll();

    public TypePrice findByid(Integer id);

    public TypePrice findByType(String typeName);

    void add(TypePrice typePrice);

    void update(TypePrice typePrice);

    void delete(Integer id);
}
