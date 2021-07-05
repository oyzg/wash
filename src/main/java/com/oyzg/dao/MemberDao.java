package com.oyzg.dao;

import com.oyzg.pojo.Member;

import java.util.List;

public interface MemberDao {

    /**
     * 根据用户名查询用户信息
     * @param mname 用户名
     * @return 返回用户，没有的话返回null
     */
    public Member queryMemberBymname(String mname);

    /**
     * 根据用户名和密码查询用户信息
     * @param mname 用户名
     * @return 返回用户，没有的话返回null
     */
    public  Member queryMemberByMnameAndPassword(String mname, String password);

    /**
     * 保存用户信息
     * @param member
     * @return 表示影响的行数，-1表示保存失败
     */
    public int saveMember(Member member);

    List<Member> findAll();

    void add(Member member);

    void update(Member member);

    void delete(Integer id);

    Member queryMemberById(Integer id);

    void updatebalance(Integer id, Integer money);
}
