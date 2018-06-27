package cn.erlaila.mybatis.po;

public class Linkman {
    private Integer linkmanid;

    private Integer userid;

    private String linkmanname;

    private String linkmanage;

    private String linkmantelephone;

    private Boolean linkmansex;

    private String adress;

    private String adressdetail;

    private Integer status;

    public Integer getLinkmanid() {
        return linkmanid;
    }

    public void setLinkmanid(Integer linkmanid) {
        this.linkmanid = linkmanid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLinkmanname() {
        return linkmanname;
    }

    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname == null ? null : linkmanname.trim();
    }

    public String getLinkmanage() {
        return linkmanage;
    }

    public void setLinkmanage(String linkmanage) {
        this.linkmanage = linkmanage == null ? null : linkmanage.trim();
    }

    public String getLinkmantelephone() {
        return linkmantelephone;
    }

    public void setLinkmantelephone(String linkmantelephone) {
        this.linkmantelephone = linkmantelephone == null ? null : linkmantelephone.trim();
    }

    public Boolean getLinkmansex() {
        return linkmansex;
    }

    public void setLinkmansex(Boolean linkmansex) {
        this.linkmansex = linkmansex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getAdressdetail() {
        return adressdetail;
    }

    public void setAdressdetail(String adressdetail) {
        this.adressdetail = adressdetail == null ? null : adressdetail.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}