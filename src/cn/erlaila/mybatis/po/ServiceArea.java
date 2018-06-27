package cn.erlaila.mybatis.po;

public class ServiceArea {
    private Integer serviceareaid;

    private String serviceareaname;

    public Integer getServiceareaid() {
        return serviceareaid;
    }

    public void setServiceareaid(Integer serviceareaid) {
        this.serviceareaid = serviceareaid;
    }

    public String getServiceareaname() {
        return serviceareaname;
    }

    public void setServiceareaname(String serviceareaname) {
        this.serviceareaname = serviceareaname == null ? null : serviceareaname.trim();
    }
}