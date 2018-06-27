package cn.erlaila.mybatis.po;

import java.util.Date;

public class Documentcomment {
    private Integer commentid;

    private String documentid;

    private Boolean anonymous;

    private Date commentvalue;

    private Boolean status;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getDocumentid() {
        return documentid;
    }

    public void setDocumentid(String documentid) {
        this.documentid = documentid == null ? null : documentid.trim();
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Date getCommentvalue() {
        return commentvalue;
    }

    public void setCommentvalue(Date commentvalue) {
        this.commentvalue = commentvalue;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}