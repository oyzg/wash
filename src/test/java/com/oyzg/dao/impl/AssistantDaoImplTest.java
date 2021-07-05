package com.oyzg.dao.impl;

import com.oyzg.dao.AssistantDao;
import com.oyzg.pojo.Assistant;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantDaoImplTest {

    AssistantDao assistantDao = new AssistantDaoImpl();

    @Test
    public void findAll() {
        System.out.println(assistantDao.findAll());
    }

    @Test
    public void add() {
        assistantDao.add(new Assistant(4,"aaa","123456"));
        System.out.println(assistantDao.findAll());
    }

    @Test
    public void update() {
        assistantDao.update(new Assistant(2,"lisi","123456"));
        System.out.println(assistantDao.findAll());
    }

    @Test
    public void delete() {
        assistantDao.delete(4);
        System.out.println(assistantDao.findAll());
    }

    @Test
    public void login() {
        Assistant zhangsan = assistantDao.findByAnameAndPassword(new Assistant("zhangsan", "123456"));
        System.out.println(zhangsan);
    }
}