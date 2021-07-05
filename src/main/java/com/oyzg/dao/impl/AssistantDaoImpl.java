package com.oyzg.dao.impl;

import com.oyzg.dao.AssistantDao;
import com.oyzg.pojo.Assistant;

import java.util.List;

public class AssistantDaoImpl extends BaseDao implements AssistantDao {
    @Override
    public List<Assistant> findAll() {
        String sql = "select aid,aname,password from assistant";
        return queryForList(Assistant.class, sql);
    }

    @Override
    public void update(Assistant assistant) {
        String sql = "update assistant set aname = ?, password = ? where aid = ?";
        update(sql,assistant.getAname(),assistant.getPassword(),assistant.getAid());
    }

    @Override
    public void add(Assistant assistant) {
        String sql = "insert into assistant values (?,?,?)";
        update(sql,assistant.getAid(),assistant.getAname(),assistant.getPassword());
    }

    @Override
    public Assistant findByid(Integer id) {
        String sql = "select aid,aname,password from assistant where aid = ?";
        return queryForOne(Assistant.class, sql, id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from assistant where aid = ?";
        update(sql, id);
    }

    @Override
    public Assistant findByAnameAndPassword(Assistant assistant) {
        String sql = "select * from assistant where aname = ? and password = ?";
        return queryForOne(Assistant.class, sql, assistant.getAname(), assistant.getPassword());
    }
}
