package com.BoeYu.pojo;

import java.util.Date;

public class Customer {
    private Long id;

    private String nickname;

    private String wxid;

    private String sex;

    private Date loginTime;

    private String address;

    private String phone;

    private String status;

    private Date createTime;

    private String fkImgId;

    private String vip;

    private Date vipTime;

    private String fkFamilyId;

    private String token;

    private Date updateTime;

    private String password;

    private String partnerId;

    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getMessage() {
        return address;
    }

    public void setMessage(String message) {
        this.address = message == null ? null : message.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFkImgId() {
        return fkImgId;
    }

    public void setFkImgId(String fkImgId) {
        this.fkImgId = fkImgId == null ? null : fkImgId.trim();
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip == null ? null : vip.trim();
    }

    public Date getVipTime() {
        return vipTime;
    }

    public void setVipTime(Date vipTime) {
        this.vipTime = vipTime;
    }

    public String getFkFamilyId() {
        return fkFamilyId;
    }

    public void setFkFamilyId(String fkFamilyId) {
        this.fkFamilyId = fkFamilyId == null ? null : fkFamilyId.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}