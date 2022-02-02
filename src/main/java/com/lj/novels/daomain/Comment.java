package com.lj.novels.daomain;

public class Comment {

    private Integer plbh;
    private Integer xsbh;
    private Integer yhbh;
    private String plsj;
    private String plnr;

    public Comment() {
    }

    public Comment(Integer plbh, Integer xsbh, Integer yhbh, String plsj, String plnr) {
        this.plbh = plbh;
        this.xsbh = xsbh;
        this.yhbh = yhbh;
        this.plsj = plsj;
        this.plnr = plnr;
    }

    public Integer getPlbh() {
        return plbh;
    }

    public void setPlbh(Integer plbh) {
        this.plbh = plbh;
    }

    public Integer getXsbh() {
        return xsbh;
    }

    public void setXsbh(Integer xsbh) {
        this.xsbh = xsbh;
    }

    public Integer getYhbh() {
        return yhbh;
    }

    public void setYhbh(Integer yhbh) {
        this.yhbh = yhbh;
    }

    public String getPlsj() {
        return plsj;
    }

    public void setPlsj(String plsj) {
        this.plsj = plsj;
    }

    public String getPlnr() {
        return plnr;
    }

    public void setPlnr(String plnr) {
        this.plnr = plnr;
    }
}
