package com.lj.novels.daomain;

public class User {

    private Integer yhbh;
    private String yhzh;
    private String yhmc;
    private String yhmm;

    public User() {
    }

    public User(Integer yhbh, String yhzh, String yhmc, String yhmm) {
        this.yhbh = yhbh;
        this.yhzh = yhzh;
        this.yhmc = yhmc;
        this.yhmm = yhmm;
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
}

