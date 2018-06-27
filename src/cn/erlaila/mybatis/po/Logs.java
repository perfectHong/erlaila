package cn.erlaila.mybatis.po;

import java.util.Date;

public class Logs {
    private Integer logsid;

    private Integer userid;

    private String operationname;

    private String classname;

    private String method;

    private Date operationtime;

    private String operationip;

    private Boolean iswechatuser;

    public Integer getLogsid() {
        return logsid;
    }

    public void setLogsid(Integer logsid) {
        this.logsid = logsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOperationname() {
        return operationname;
    }

    public void setOperationname(String operationname) {
        this.operationname = operationname == null ? null : operationname.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getOperationip() {
        return operationip;
    }

    public void setOperationip(String operationip) {
        this.operationip = operationip == null ? null : operationip.trim();
    }

    public Boolean getIswechatuser() {
        return iswechatuser;
    }

    public void setIswechatuser(Boolean iswechatuser) {
        this.iswechatuser = iswechatuser;
    }
}