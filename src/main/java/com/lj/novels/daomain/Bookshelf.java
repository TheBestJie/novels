package com.lj.novels.daomain;

public class Bookshelf {
    private Integer sjbh;
    private Integer yhbh;
    private Integer xsbh;

    public Bookshelf() {
    }

    public Bookshelf(Integer sjbh, Integer yhbh, Integer xsbh) {
        this.sjbh = sjbh;
        this.yhbh = yhbh;
        this.xsbh = xsbh;
    }

    public Integer getSjbh() {
        return sjbh;
    }

    public void setSjbh(Integer sjbh) {
        this.sjbh = sjbh;
    }

    public Integer getYhbh() {
        return yhbh;
    }

    public void setYhbh(Integer yhbh) {
        this.yhbh = yhbh;
    }

    public Integer getXsbh() {
        return xsbh;
    }

    public void setXsbh(Integer xsbh) {
        this.xsbh = xsbh;
    }
}
