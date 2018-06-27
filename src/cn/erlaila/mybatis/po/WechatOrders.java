package cn.erlaila.mybatis.po;

public class WechatOrders {
    private Integer id;

    private Integer orderid;

    private Integer wechatId;

    private Integer money;

    private Integer moneypay;

    private Integer paystatus;

    private Integer nursestatus;

    private Integer servicestatus;

    private Integer delestatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getWechatId() {
        return wechatId;
    }

    public void setWechatId(Integer wechatId) {
        this.wechatId = wechatId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoneypay() {
        return moneypay;
    }

    public void setMoneypay(Integer moneypay) {
        this.moneypay = moneypay;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getNursestatus() {
        return nursestatus;
    }

    public void setNursestatus(Integer nursestatus) {
        this.nursestatus = nursestatus;
    }

    public Integer getServicestatus() {
        return servicestatus;
    }

    public void setServicestatus(Integer servicestatus) {
        this.servicestatus = servicestatus;
    }

    public Integer getDelestatus() {
        return delestatus;
    }

    public void setDelestatus(Integer delestatus) {
        this.delestatus = delestatus;
    }
}