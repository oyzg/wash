package com.oyzg.service;

import com.oyzg.pojo.Member;

import java.util.List;

public interface MemberService {

    /**
     * 注册用户
     * @param member
     */
    public void registMember(Member member);

    /**
     * 登录
     * @param member
     * @return Member
     */
    public Member login(Member member);

    /**
     *检查用户名是否可用
     * @param mname
     * @return true表示用户名已存在，false表示用户名可用
     */
    public boolean existsMname(String mname);

    List<Member> findAll();

    void add(Member member);

    void update(Member member);

    void delete(Integer id);

    Member findById(Integer id);

    void recharge(Integer id, Integer money);
}
