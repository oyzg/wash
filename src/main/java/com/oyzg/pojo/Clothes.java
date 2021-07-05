package com.oyzg.pojo;

import java.sql.Date;

public class Clothes {

    private Integer cid;
    private Integer ccount;
    private Integer mid;
    private Integer aid;
    private String date;
    private Integer tid;

    public Clothes() {
    }

    public Clothes(Integer cid, Integer ccount, Integer mid, Integer aid, String date, Integer tid) {
        this.cid = cid;
        this.ccount = ccount;
        this.mid = mid;
        this.aid = aid;
        this.date = date;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "cid=" + cid +
                ", ccount=" + ccount +
                ", mid=" + mid +
                ", aid=" + aid +
                ", date=" + date +
                ", tid=" + tid +
                '}';
    }



    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }


}
