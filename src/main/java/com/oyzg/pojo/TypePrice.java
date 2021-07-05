package com.oyzg.pojo;

public class TypePrice {

    private Integer tid;
    private String tname;
    private Integer unitprice;

    public TypePrice(Integer tid, String tname, Integer unitprice) {
        this.tid = tid;
        this.tname = tname;
        this.unitprice = unitprice;
    }

    public TypePrice() {
    }

    @Override
    public String toString() {
        return "TypePrice{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", unitprice=" + unitprice +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }
}
