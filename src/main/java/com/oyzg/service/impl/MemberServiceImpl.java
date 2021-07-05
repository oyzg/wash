package com.oyzg.service.impl;

import com.oyzg.dao.MemberDao;
import com.oyzg.dao.impl.MemberDaoImpl;
import com.oyzg.pojo.Member;
import com.oyzg.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public void registMember(Member member) {
        memberDao.saveMember(member);
    }

    @Override
    public Member login(Member member) {
        return memberDao.queryMemberByMnameAndPassword(member.getMname(),member.getPassword());
    }

    @Override
    public boolean existsMname(String mname) {
        return memberDao.queryMemberBymname(mname) != null;
    }

    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public void add(Member member) {
        memberDao.add(member);
    }

    @Override
    public void update(Member member) {
        memberDao.update(member);
    }

    @Override
    public void delete(Integer id) {
        memberDao.delete(id);
    }

    @Override
    public Member findById(Integer id) {
        return memberDao.queryMemberById(id);
    }

    @Override
    public void recharge(Integer id, Integer money) {
        memberDao.updatebalance(id,money);
    }
}
