package com.BoeYu.pojo;

import java.util.Date;

public class Dictionary {
    private Integer id;

    private String nkey;

    private String value;

    private String flag;

    private Date createtime;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNkey() {
        return nkey;
    }

    public void setNkey(String nkey) {
        this.nkey = nkey == null ? null : nkey.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
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