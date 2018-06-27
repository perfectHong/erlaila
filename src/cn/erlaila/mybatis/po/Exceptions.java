package cn.erlaila.mybatis.po;

import java.util.Date;

public class Exceptions {
    private Integer exceptionid;

    private Integer userid;

    private String classname;

    private String exceptionname;

    private Date timehap;

    private String exceptionip;

    public Integer getExceptionid() {
        return exceptionid;
    }

    public void setExceptionid(Integer exceptionid) {
        this.exceptionid = exceptionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getExceptionname() {
        return exceptionname;
    }

    public void setExceptionname(String exceptionname) {
        this.exceptionname = exceptionname == null ? null : exceptionname.trim();
    }

    public Date getTimehap() {
        return timehap;
    }

    public void setTimehap(Date timehap) {
        this.timehap = timehap;
    }

    public String getExceptionip() {
        return exceptionip;
    }

    public void setExceptionip(String exceptionip) {
        this.exceptionip = exceptionip == null ? null : exceptionip.trim();
    }
}