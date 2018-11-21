package com.BoeYu.pojo;

import java.util.Date;

public class Child {
    private Integer id;

    private String name;

    private String sex;

    private String grade;

    private Date years;

    private Date createTime;

    private String android;

    private String flag;

    private String fkFamilyId;

    private String fkImgId;

    private String coordinate;

    private String childType;

    private Date lockStartetime;

    private Date lockEndtime;

    private String fkCustomerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android == null ? null : android.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getFkFamilyId() {
        return fkFamilyId;
    }

    public void setFkFamilyId(String fkFamilyId) {
        this.fkFamilyId = fkFamilyId == null ? null : fkFamilyId.trim();
    }

    public String getFkImgId() {
        return fkImgId;
    }

    public void setFkImgId(String fkImgId) {
        this.fkImgId = fkImgId == null ? null : fkImgId.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public String getChildType() {
        return childType;
    }

    public void setChildType(String childType) {
        this.childType = childType == null ? null : childType.trim();
    }

    public Date getLockStartetime() {
        return lockStartetime;
    }

    public void setLockStartetime(Date lockStartetime) {
        this.lockStartetime = lockStartetime;
    }

    public Date getLockEndtime() {
        return lockEndtime;
    }

    public void setLockEndtime(Date lockEndtime) {
        this.lockEndtime = lockEndtime;
    }

    public String getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(String fkCustomerId) {
        this.fkCustomerId = fkCustomerId == null ? null : fkCustomerId.trim();
    }
}