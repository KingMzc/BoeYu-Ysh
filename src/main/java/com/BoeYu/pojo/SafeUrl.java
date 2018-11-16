package com.BoeYu.pojo;

import java.util.Date;

public class SafeUrl {
    private Integer id;

    private String safeType;

    private String safeContent;

    private String fkCustomerId;

    private String fkChildId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSafeType() {
        return safeType;
    }

    public void setSafeType(String safeType) {
        this.safeType = safeType == null ? null : safeType.trim();
    }

    public String getSafeContent() {
        return safeContent;
    }

    public void setSafeContent(String safeContent) {
        this.safeContent = safeContent == null ? null : safeContent.trim();
    }

    public String getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(String fkCustomerId) {
        this.fkCustomerId = fkCustomerId == null ? null : fkCustomerId.trim();
    }

    public String getFkChildId() {
        return fkChildId;
    }

    public void setFkChildId(String fkChildId) {
        this.fkChildId = fkChildId == null ? null : fkChildId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}