package com.oyzg.pojo;

public class Member {

    private Integer mid;
    private String mname;
    private Integer grade;
    private Integer balance;
    private String password;

    public Member(Integer mid, String mname, Integer grade, Integer balance, String password) {
        this.mid = mid;
        this.mname = mname;
        this.grade = grade;
        this.balance = balance;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", grade=" + grade +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }

    public Member(String mname, String password) {
        this.mname = mname;
        this.password = password;
    }

    public Member() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
