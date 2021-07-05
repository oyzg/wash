package com.oyzg.service;

import com.oyzg.pojo.Assistant;
import com.oyzg.pojo.Clothes;
import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;
import com.oyzg.service.impl.ClothesServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class ClothesServiceTest {

    private ClothesService clothesService = new ClothesServiceImpl();

    @Test
    public void findByCId() {
        System.out.println(clothesService.findByCId(1));
    }

    @Test
    public void findByMId() {
        System.out.println(clothesService.findByMId(1));
    }

    @Test
    public void findByTId() {
        System.out.println(clothesService.findByTId(1));
    }

    @Test
    public void findByAId() {
        System.out.println(clothesService.findByAId(new Assistant(1,"","")));
    }

    @Test
    public void queryAll() {
        System.out.println(clothesService.queryAll());
    }

    @Test
    public void add() {
        clothesService.add(new Clothes());
        System.out.println(clothesService.queryAll());
    }

    @Test
    public void update() throws ParseException {
//        clothesService.update(new Clothes(4,1,5,3,new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-01"),1));
        clothesService.update(new Clothes(10,1,5,3,"2021-07-01",1));
        System.out.println(clothesService.queryAll());
    }

    @Test
    public void delete() {
        clothesService.delete(4);
        System.out.println(clothesService.queryAll());
    }

}