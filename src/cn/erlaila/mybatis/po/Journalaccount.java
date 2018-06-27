package cn.erlaila.mybatis.po;

import java.util.Date;

public class Journalaccount {
    private Integer journalaccountid;

    private Integer userid;

    private Integer orderid;

    private Integer money;

    private Date timehap;

    public Integer getJournalaccountid() {
        return journalaccountid;
    }

    public void setJournalaccountid(Integer journalaccountid) {
        this.journalaccountid = journalaccountid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getTimehap() {
        return timehap;
    }

    public void setTimehap(Date timehap) {
        this.timehap = timehap;
    }
}