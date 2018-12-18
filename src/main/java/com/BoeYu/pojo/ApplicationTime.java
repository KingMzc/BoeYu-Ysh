package com.BoeYu.pojo;

import java.util.Date;

public class ApplicationTime {

    private Integer id;

    private String applicationType;

    private String applicationImg;

    private Date createtime;

    private String fkChildId;

    private String lockType;

    private String appTime;

    private String applicationId;

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
        this.applicationType = applicationType;
    }

    public String getApplicationImg() {
        return applicationImg;
    }

    public void setApplicationImg(String applicationImg) {
        this.applicationImg = applicationImg;
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
        this.fkChildId = fkChildId;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getAppUpdatetime() {
        return appUpdatetime;
    }

    public void setAppUpdatetime(String appUpdatetime) {
        this.appUpdatetime = appUpdatetime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    private String applicationName;

    private String appUpdatetime;

    private String week;

    private String times;
}
