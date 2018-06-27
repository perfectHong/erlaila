package cn.erlaila.mybatis.po;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private Integer linkmanId;

    private Integer servicetypeId;

    private Integer userId;

    private Integer nurseId;

    private String orderWechatid;

    private Integer favourableid;

    private String createordername;

    private String orderWechat;

    private String orderDuring;

    private Date orderStarttime;

    private Date orderTimeend;

    private Date orderTime;

    private Integer orderMoney;

    private Integer orderMoneypay;

    private Integer orderStatus;

    private Integer delestatus;

    private String orderComment;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(Integer linkmanId) {
        this.linkmanId = linkmanId;
    }

    public Integer getServicetypeId() {
        return servicetypeId;
    }

    public void setServicetypeId(Integer servicetypeId) {
        this.servicetypeId = servicetypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public String getOrderWechatid() {
        return orderWechatid;
    }

    public void setOrderWechatid(String orderWechatid) {
        this.orderWechatid = orderWechatid == null ? null : orderWechatid.trim();
    }

    public Integer getFavourableid() {
        return favourableid;
    }

    public void setFavourableid(Integer favourableid) {
        this.favourableid = favourableid;
    }

    public String getCreateordername() {
        return createordername;
    }

    public void setCreateordername(String createordername) {
        this.createordername = createordername == null ? null : createordername.trim();
    }

    public String getOrderWechat() {
        return orderWechat;
    }

    public void setOrderWechat(String orderWechat) {
        this.orderWechat = orderWechat == null ? null : orderWechat.trim();
    }

    public String getOrderDuring() {
        return orderDuring;
    }

    public void setOrderDuring(String orderDuring) {
        this.orderDuring = orderDuring == null ? null : orderDuring.trim();
    }

    public Date getOrderStarttime() {
        return orderStarttime;
    }

    public void setOrderStarttime(Date orderStarttime) {
        this.orderStarttime = orderStarttime;
    }

    public Date getOrderTimeend() {
        return orderTimeend;
    }

    public void setOrderTimeend(Date orderTimeend) {
        this.orderTimeend = orderTimeend;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderMoneypay() {
        return orderMoneypay;
    }

    public void setOrderMoneypay(Integer orderMoneypay) {
        this.orderMoneypay = orderMoneypay;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getDelestatus() {
        return delestatus;
    }

    public void setDelestatus(Integer delestatus) {
        this.delestatus = delestatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }
}