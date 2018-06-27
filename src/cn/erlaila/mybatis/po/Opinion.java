package cn.erlaila.mybatis.po;

import java.util.Date;

public class Opinion {
    private Integer opinionid;

    private Integer userid;

    private Date opiniontime;

    private String coment;

    public Integer getOpinionid() {
        return opinionid;
    }

    public void setOpinionid(Integer opinionid) {
        this.opinionid = opinionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getOpiniontime() {
        return opiniontime;
    }

    public void setOpiniontime(Date opiniontime) {
        this.opiniontime = opiniontime;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment == null ? null : coment.trim();
    }
}