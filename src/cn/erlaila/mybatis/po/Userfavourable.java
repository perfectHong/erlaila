package cn.erlaila.mybatis.po;

import java.util.Date;

public class Userfavourable {
    private Integer ufid;

    private Integer userid;

    private Integer favourableid;

    private Integer status;

    private Date getstarttime;

    private Date usetime;

    public Integer getUfid() {
        return ufid;
    }

    public void setUfid(Integer ufid) {
        this.ufid = ufid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFavourableid() {
        return favourableid;
    }

    public void setFavourableid(Integer favourableid) {
        this.favourableid = favourableid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGetstarttime() {
        return getstarttime;
    }

    public void setGetstarttime(Date getstarttime) {
        this.getstarttime = getstarttime;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }
}