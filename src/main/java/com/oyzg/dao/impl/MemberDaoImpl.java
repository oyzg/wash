package com.oyzg.dao.impl;

import com.oyzg.dao.MemberDao;
import com.oyzg.pojo.Member;

import java.util.List;

public class MemberDaoImpl extends BaseDao implements MemberDao {
    @Override
    public Member queryMemberBymname(String mname) {
        String sql = "select mid,mname,grade,balance,password from member where mname = ?";
        return queryForOne(Member.class,sql,mname);
    }

    @Override
    public Member queryMemberByMnameAndPassword(String mname, String password) {
        String sql = "select mid,mname,grade,balance,password from member where mname = ? and password = ?";
        return queryForOne(Member.class, sql, mname, password);
    }

    @Override
    public int saveMember(Member member) {
        String sql = "insert into member(mname,grade,balance,password) values (?,?,?,?)";
        return update(sql,member.getMname(),member.getGrade(),member.getBalance(),member.getPassword());
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from member";
        return queryForList(Member.class, sql);
    }

    @Override
    public void add(Member member) {
        String sql = "insert into member values (null,?,?,?,?)";
        update(sql,member.getMname(),member.getGrade(),member.getBalance(),member.getPassword());
    }

    @Override
    public void update(Member member) {
        String sql = "update member set mname = ?,grade = ?, balance = ?, password = ? where mid = ?";
        update(sql,member.getMname(),member.getGrade(),member.getBalance(),member.getPassword(),member.getMid());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from member where mid = ?";
        update(sql, id);
    }

    @Override
    public Member queryMemberById(Integer id) {
        String sql = "select * from member where mid = ?";
        return queryForOne(Member.class, sql, id);
    }

    @Override
    public void updatebalance(Integer id, Integer money) {
        Member member = queryMemberById(id);
        int newBalance = money+member.getBalance();
        String sql = "update member set balance = ? where mid = ?";
        update(sql, newBalance, id);
    }
}
