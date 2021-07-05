package com.oyzg.service;

import com.oyzg.service.impl.TypeServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypeServiceTest {

    private TypeService typeService = new TypeServiceImpl();

    @Test
    public void findAll() {
        System.out.println(typeService.findAll());
    }

    @Test
    public void findByid() {
        System.out.println(typeService.findByid(1));
    }

    @Test
    public void findByType() {
        System.out.println(typeService.findByType("T恤"));
    }
}