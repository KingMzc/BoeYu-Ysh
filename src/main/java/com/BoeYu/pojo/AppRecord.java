package com.BoeYu.pojo;

import java.util.Date;

public class AppRecord {
    private Integer id;

    private String fkChildId;

    private String type;

    private String flag;

    private Date createTime;

    private String imgtb;

    private String appid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkChildId() {
        return fkChildId;
    }

    public void setFkChildId(String fkChildId) {
        this.fkChildId = fkChildId == null ? null : fkChildId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgtb() {
        return imgtb;
    }

    public void setImgtb(String imgtb) {
        this.imgtb = imgtb == null ? null : imgtb.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }
}