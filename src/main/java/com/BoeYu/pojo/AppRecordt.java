package com.BoeYu.pojo;

import java.util.Date;

public class AppRecordt {

    private String applicationImg;
    private String applicationName;
    private String time;
    private Date recordTime;

    public String getApplicationImg() {
        return applicationImg;
    }

    public void setApplicationImg(String applicationImg) {
        this.applicationImg = applicationImg;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
