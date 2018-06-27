package cn.erlaila.mybatis.po;

import java.util.Date;

public class Admins {
    private Integer adminid;

    private String adminname;

    private String password;

    private String realname;

    private Boolean sex;

    private String telphon;

    private Date birthday;

    private String email;

    private String commentas;

    private String icon;

    private Integer admingroup;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getTelphon() {
        return telphon;
    }

    public void setTelphon(String telphon) {
        this.telphon = telphon == null ? null : telphon.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCommentas() {
        return commentas;
    }

    public void setCommentas(String commentas) {
        this.commentas = commentas == null ? null : commentas.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getAdmingroup() {
        return admingroup;
    }

    public void setAdmingroup(Integer admingroup) {
        this.admingroup = admingroup;
    }
}