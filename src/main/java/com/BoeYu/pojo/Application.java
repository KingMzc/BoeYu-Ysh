package com.BoeYu.pojo;

import java.util.Date;

public class Application {
    private Integer id;

    private String applicationType;

    private String applicationImg;

    private Date createtime;

    private String fkChildId;

    private String lockType;

    private String appTime;

    private String applicationId;

    private String applicationName;

    private String appUpdatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType == null ? null : applicationType.trim();
    }

    public String getApplicationImg() {
        return applicationImg;
    }

    public void setApplicationImg(String applicationImg) {
        this.applicationImg = applicationImg == null ? null : applicationImg.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFkChildId() {
        return fkChildId;
    }

    public void setFkChildId(String fkChildId) {
        this.fkChildId = fkChildId == null ? null : fkChildId.trim();
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType == null ? null : lockType.trim();
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime == null ? null : appTime.trim();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId == null ? null : applicationId.trim();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    public String getAppUpdatetime() {
        return appUpdatetime;
    }

    public void setAppUpdatetime(String appUpdatetime) {
        this.appUpdatetime = appUpdatetime == null ? null : appUpdatetime.trim();
    }


}