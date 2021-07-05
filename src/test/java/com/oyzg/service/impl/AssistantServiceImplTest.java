package com.oyzg.service.impl;

import com.oyzg.pojo.Assistant;
import com.oyzg.service.AssistantService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssistantServiceImplTest {

    AssistantService assistantService = new AssistantServiceImpl();

    @Test
    public void findAll() {
        System.out.println(assistantService.findAll());
    }

    @Test
    public void update() {
        assistantService.update(new Assistant(2,"wangwu","123456"));
        System.out.println(assistantService.findAll());
    }

    @Test
    public void delete() {
        assistantService.delete(2);
        System.out.println(assistantService.findAll());
    }

    @Test
    public void login() {
        Assistant zhangsan = assistantService.login(new Assistant("zhangsan", "123456"));
        System.out.println(zhangsan);
    }
}