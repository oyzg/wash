package com.oyzg.service.impl;

import com.oyzg.pojo.Member;
import com.oyzg.service.MemberService;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    public void registMember() {
        Member member = new Member(null,"carl",0,0,"123456");
        memberService.registMember(member);
    }

    @Test
    public void login() {
        Member member = new Member(null,"carl",0,0,"123456");
        Member login = memberService.login(member);
        System.out.println(login);
    }

    @Test
    public void existsMname() {
        System.out.println(memberService.existsMname("tom"));
    }

    @Test
    public void findAll() {
        System.out.println(memberService.findAll());
    }

    @Test
    public void add() {
        memberService.add(new Member(2,"oyzg152",1,0,"oyzg152"));
        System.out.println(memberService.findAll());
    }

    @Test
    public void update() {
        memberService.update(new Member(2,"oyzg152",1,0,"oyzg152"));
        System.out.println(memberService.findAll());
    }

    @Test
    public void delete() {
        memberService.delete(3);
        System.out.println(memberService.findAll());
    }
}