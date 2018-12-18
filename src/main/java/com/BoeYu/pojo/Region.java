package com.BoeYu.pojo;

import java.util.Date;

public class Region {
    private Integer id;

    private String fkChildId;

    private String mater;

    private String coordinate;

    private Date createtime;

    private String name;

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

    public String getMater() {
        return mater;
    }

    public void setMater(String mater) {
        this.mater = mater == null ? null : mater.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}