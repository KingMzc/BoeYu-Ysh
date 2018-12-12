package com.BoeYu.pojo;

public class ChildKey {
    private Integer id;

    private String android;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android == null ? null : android.trim();
    }
}