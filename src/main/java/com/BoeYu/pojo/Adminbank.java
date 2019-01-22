package com.BoeYu.pojo;

import java.util.Date;

public class Adminbank {
    private Integer id;

    private String fkAdminId;

    private String bankimg;

    private String bankid;

    private String bankname;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkAdminId() {
        return fkAdminId;
    }

    public void setFkAdminId(String fkAdminId) {
        this.fkAdminId = fkAdminId == null ? null : fkAdminId.trim();
    }

    public String getBankimg() {
        return bankimg;
    }

    public void setBankimg(String bankimg) {
        this.bankimg = bankimg == null ? null : bankimg.trim();
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}