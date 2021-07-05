package com.oyzg.service;

import com.oyzg.pojo.Assistant;

import java.util.List;

public interface AssistantService {

    public List<Assistant> findAll();

    void update(Assistant assistant);

    void add(Assistant assistant);

    Assistant findByid(Integer id);

    void delete(Integer id);

    Assistant login(Assistant assistant);
}
