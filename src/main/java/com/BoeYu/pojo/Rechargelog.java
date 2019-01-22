package com.BoeYu.pojo;

import java.util.Date;

public class Rechargelog {
    private Integer id;

    private String fkCustomerId;

    private Date createtime;

    private String money;

    private String fkPartnerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(String fkCustomerId) {
        this.fkCustomerId = fkCustomerId == null ? null : fkCustomerId.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getFkPartnerId() {
        return fkPartnerId;
    }

    public void setFkPartnerId(String fkPartnerId) {
        this.fkPartnerId = fkPartnerId == null ? null : fkPartnerId.trim();
    }
}