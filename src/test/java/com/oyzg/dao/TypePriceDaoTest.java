package com.oyzg.dao;

import com.oyzg.dao.impl.TypePriceDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypePriceDaoTest {

    private TypePriceDao typePriceDao = new TypePriceDaoImpl();

    @Test
    public void queryByType() {
        System.out.println(typePriceDao.queryByType("T恤"));
    }

    @Test
    public void queryById() {
        System.out.println(typePriceDao.queryById(2));
    }

    @Test
    public void queryAll() {
        System.out.println(typePriceDao.queryAll());
    }
}