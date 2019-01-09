package com.BoeYu.pojo;

import java.util.Date;

public class ApplicationRecord {
    private Integer id;

    private String fkApplicationId;

    private String time;

    private Date recordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkApplicationId() {
        return fkApplicationId;
    }

    public void setFkApplicationId(String fkApplicationId) {
        this.fkApplicationId = fkApplicationId == null ? null : fkApplicationId.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}