package com.lj.novels.daomain;

public class UserComment {

    private Integer yhbh;
    private String yhzh;
    private String yhmc;
    private String yhmm;

    private Integer plbh;
    private String plsj;
    private String plnr;

    public UserComment() {
    }

    public UserComment(Integer yhbh, String yhzh, String yhmc, String yhmm, Integer plbh, String plsj, String plnr) {
        this.yhbh = yhbh;
        this.yhzh = yhzh;
        this.yhmc = yhmc;
        this.yhmm = yhmm;
        this.plbh = plbh;
        this.plsj = plsj;
        this.plnr = plnr;
    }

    public Integer getYhbh() {
        return yhbh;
    }

    public void setYhbh(Integer yhbh) {
        this.yhbh = yhbh;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }

    public String getYhmm() {
        return yhmm;
    }

    public void setYhmm(String yhmm) {
        this.yhmm = yhmm;
    }

    public Integer getPlbh() {
        return plbh;
    }

    public void setPlbh(Integer plbh) {
        this.plbh = plbh;
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
