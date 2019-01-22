package com.BoeYu.pojo;

import java.util.Date;

public class Cashlog {
    private Integer id;

    private String fkPartnerId;

    private String money;

    private String tmoney;

    private String idcardz;

    private String idcardf;

    private String bank;

    private String flag;

    private String adname;

    private String admsg;

    private String zhanghu;

    private String bankid;

    private String nickname;

    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getTmoney() {
        return tmoney;
    }

    public void setTmoney(String tmoney) {
        this.tmoney = tmoney == null ? null : tmoney.trim();
    }

    public String getIdcardz() {
        return idcardz;
    }

    public void setIdcardz(String idcardz) {
        this.idcardz = idcardz == null ? null : idcardz.trim();
    }

    public String getIdcardf() {
        return idcardf;
    }

    public void setIdcardf(String idcardf) {
        this.idcardf = idcardf == null ? null : idcardf.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }

    public String getAdmsg() {
        return admsg;
    }

    public void setAdmsg(String admsg) {
        this.admsg = admsg == null ? null : admsg.trim();
    }

    public String getZhanghu() {
        return zhanghu;
    }

    public void setZhanghu(String zhanghu) {
        this.zhanghu = zhanghu == null ? null : zhanghu.trim();
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }
}