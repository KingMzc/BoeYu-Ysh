package com.BoeYu.pojo;

public class RegionTime {
    private Integer id;

    private String week;

    private String starttime;

    private String fkRegionId;

    private String flag;

    private String endtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getFkRegionId() {
        return fkRegionId;
    }

    public void setFkRegionId(String fkRegionId) {
        this.fkRegionId = fkRegionId == null ? null : fkRegionId.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }
}