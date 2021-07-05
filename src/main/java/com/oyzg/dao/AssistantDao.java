package com.oyzg.dao;

import com.oyzg.pojo.Assistant;

import java.util.List;

public interface AssistantDao {

    public List<Assistant> findAll();


    void update(Assistant assistant);

    void add(Assistant assistant);

    Assistant findByid(Integer id);

    void delete(Integer id);

    Assistant findByAnameAndPassword(Assistant assistant);
}
