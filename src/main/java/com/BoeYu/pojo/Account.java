package com.BoeYu.pojo;

public class Account {
    private Integer id;

    private String fkPartnerId;

    private String money;

    private String smoney;

    private String tmoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkPartnerId() {
        return fkPartnerId;
    }

    public void setFkPartnerId(String fkPartnerId) {
        this.fkPartnerId = fkPartnerId == null ? null : fkPartnerId.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getSmoney() {
        return smoney;
    }

    public void setSmoney(String smoney) {
        this.smoney = smoney == null ? null : smoney.trim();
    }

    public String getTmoney() {
        return tmoney;
    }

    public void setTmoney(String tmoney) {
        this.tmoney = tmoney == null ? null : tmoney.trim();
    }
}