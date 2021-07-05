package com.oyzg.dao;

import com.oyzg.dao.impl.ClothesDaoImpl;
import com.oyzg.pojo.Clothes;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ClothesDaoTest {

    private ClothesDao clothesDao = new ClothesDaoImpl();

    @Test
    public void queryByCId() {
        System.out.println(clothesDao.queryByCId(1));
    }

    @Test
    public void queryByMId() {
        System.out.println(clothesDao.queryByMId(5));
    }

    @Test
    public void queryByTId() {
        System.out.println(clothesDao.queryByTId(1));
    }

    @Test
    public void queryByAId() {
        System.out.println(clothesDao.queryByAId(3));
    }

    @Test
    public void queryAll() {
        System.out.println(clothesDao.queryAll());
    }

    @Test
    public void add() {
        clothesDao.add(new Clothes());
        System.out.println(clothesDao.queryAll());
    }

    @Test
    public void update() throws ParseException {
        clothesDao.update(new Clothes(3,1,5,3,"2021-06-29",1));
        System.out.println(clothesDao.queryAll());
    }

    @Test
    public void delete() {
        clothesDao.delete(3);
        System.out.println(clothesDao.queryAll());
    }
}