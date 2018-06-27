package cn.erlaila.mybatis.po;

import java.util.Date;

public class DayAccount {
    private Integer dayaccountid;

    private Integer num;

    private Integer money;

    private Date timehap;

    public Integer getDayaccountid() {
        return dayaccountid;
    }

    public void setDayaccountid(Integer dayaccountid) {
        this.dayaccountid = dayaccountid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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