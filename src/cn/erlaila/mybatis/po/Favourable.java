package cn.erlaila.mybatis.po;

import java.util.Date;

public class Favourable {
    private Integer favourableid;

    private String favourablename;

    private String favourabledetail;

    private String favourableicon;

    private Integer favourablemoney;

    private Date starttime;

    private Date endtime;

    public Integer getFavourableid() {
        return favourableid;
    }

    public void setFavourableid(Integer favourableid) {
        this.favourableid = favourableid;
    }

    public String getFavourablename() {
        return favourablename;
    }

    public void setFavourablename(String favourablename) {
        this.favourablename = favourablename == null ? null : favourablename.trim();
    }

    public String getFavourabledetail() {
        return favourabledetail;
    }

    public void setFavourabledetail(String favourabledetail) {
        this.favourabledetail = favourabledetail == null ? null : favourabledetail.trim();
    }

    public String getFavourableicon() {
        return favourableicon;
    }

    public void setFavourableicon(String favourableicon) {
        this.favourableicon = favourableicon == null ? null : favourableicon.trim();
    }

    public Integer getFavourablemoney() {
        return favourablemoney;
    }

    public void setFavourablemoney(Integer favourablemoney) {
        this.favourablemoney = favourablemoney;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}