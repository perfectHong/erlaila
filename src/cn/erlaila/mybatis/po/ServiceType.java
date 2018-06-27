package cn.erlaila.mybatis.po;

public class ServiceType {
    private Integer serviceid;

    private String servicename;

    private String servicemu;

    private Integer price;

    private Integer nursegetmoney;

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }

    public String getServicemu() {
        return servicemu;
    }

    public void setServicemu(String servicemu) {
        this.servicemu = servicemu == null ? null : servicemu.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNursegetmoney() {
        return nursegetmoney;
    }

    public void setNursegetmoney(Integer nursegetmoney) {
        this.nursegetmoney = nursegetmoney;
    }
}