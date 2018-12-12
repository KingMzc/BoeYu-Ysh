package com.BoeYu.pojo;

import java.util.Date;

public class Child extends ChildKey {
    private String name;

    private String sex;

    private String grade;

    private Date years;

    private Date createTime;

    private String flag;

    private String fkFamilyId;

    private String fkImgId;

    private String coordinate;

    private String childType;

    private String safeType;

    private String type;

    private String fkCustomerId;

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

    public String getSafeType() {
        return safeType;
    }

    public void setSafeType(String safeType) {
        this.safeType = safeType == null ? null : safeType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFkCustomerId() {
        return fkCustomerId;
    }

    public void setFkCustomerId(String fkCustomerId) {
        this.fkCustomerId = fkCustomerId == null ? null : fkCustomerId.trim();
    }
}