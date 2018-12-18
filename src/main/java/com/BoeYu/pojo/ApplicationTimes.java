package com.BoeYu.pojo;

public class ApplicationTimes {
    private Integer id;

    private String week;

    private String fkApplicationId;

    private String times;

    private String flag;

    private String type;

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

    public String getFkApplicationId() {
        return fkApplicationId;
    }

    public void setFkApplicationId(String fkApplicationId) {
        this.fkApplicationId = fkApplicationId == null ? null : fkApplicationId.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}