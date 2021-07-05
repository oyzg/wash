package com.oyzg.service.impl;

import com.oyzg.dao.AssistantDao;
import com.oyzg.dao.impl.AssistantDaoImpl;
import com.oyzg.pojo.Assistant;
import com.oyzg.service.AssistantService;

import java.util.List;

public class AssistantServiceImpl implements AssistantService {

    private AssistantDao assistantDao = new AssistantDaoImpl();

    @Override
    public List<Assistant> findAll() {
        return assistantDao.findAll();
    }

    @Override
    public void update(Assistant assistant) {
        assistantDao.update(assistant);
    }

    @Override
    public void add(Assistant assistant) {
        assistantDao.add(assistant);
    }

    @Override
    public Assistant findByid(Integer id) {
        return assistantDao.findByid(id);
    }

    @Override
    public void delete(Integer id) {
        assistantDao.delete(id);
    }

    @Override
    public Assistant login(Assistant assistant) {
        return assistantDao.findByAnameAndPassword(assistant);
    }
}
