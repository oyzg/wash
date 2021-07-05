package com.oyzg.dao.impl;

import com.oyzg.pojo.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberDaoImplTest {

    @Test
    public void queryMemberBymname() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.queryMemberBymname("tom"));
    }

    @Test
    public void queryMemberByMnameAndPassword() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.queryMemberByMnameAndPassword("tom","123456"));
    }

    @Test
    public void saveMember() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        Member member = new Member(null,"lucy",0,0,"123456");
        System.out.println(memberDao.saveMember(member));
    }

    @Test
    public void findAll() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.findAll());
    }

    @Test
    public void add() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        memberDao.add(new Member(5,"carl",0,0,"123456"));
        System.out.println(memberDao.findAll());
    }

    @Test
    public void update() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        memberDao.update(new Member(1,"carl",0,0,"123456"));
        System.out.println(memberDao.findAll());
    }

    @Test
    public void delete() {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        memberDao.delete(2);
        System.out.println(memberDao.findAll());
    }




}