package com.oyzg.pojo;

public class Assistant {

    private Integer aid;
    private String aname;
    private String password;

    public Assistant(Integer aid, String aname, String password) {
        this.aid = aid;
        this.aname = aname;
        this.password = password;
    }

    public Assistant(String aname, String password) {
        this.aname = aname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Assistant() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
